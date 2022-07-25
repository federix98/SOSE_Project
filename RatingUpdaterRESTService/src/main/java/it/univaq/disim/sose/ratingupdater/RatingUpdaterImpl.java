package it.univaq.disim.sose.ratingupdater;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.ratingupdater.model.RatingData;
import it.univaq.disim.sose.ratingupdater.model.RatingOperationResponse;
import it.univaq.disim.sose.ratingupdater.service.RatingUpdaterService;
import it.univaq.disim.sose.ratingupdater.utils.UtilityMethods;

public class RatingUpdaterImpl implements RatingUpdater {
	
	@Override
	public String addRatings(int userId, String filmId, int filmDirectionRating, int actorsRating, int globalScoreRating, int dialoguesRating, int costumesRating) {
		// TODO Auto-generated method stub
		
		RatingData objToAdd = new RatingData(filmId, userId, filmDirectionRating, actorsRating, globalScoreRating, dialoguesRating, costumesRating);
		
		try {
			boolean done = RatingUpdaterService.getInstance().addRating(objToAdd);
			
			if (done) {
				RatingUpdaterService.getInstance().updateGlobalScore(objToAdd);
				return new RatingOperationResponse("Rating inserted and global score updated", true).getJSONResponse();
			}
			return new RatingOperationResponse("User has already inserted the ratings for the film", false).getJSONResponse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new RatingOperationResponse("Exception during add ratings", false).getJSONResponse();
		}
		
		
	}

	@Override
	public String getRatingAvgs(String filmId) {
		// TODO Auto-generated method stub
		
		try {
			return new JSONObject(RatingUpdaterService.getInstance().getRatingAverages(filmId)).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JSONObject(new RatingOperationResponse("Exeption retrieving averages", false)).toString();
		}
	}

	@Override
	public String getAllRatings(String filmId) {
		try {
			return new JSONArray(RatingUpdaterService.getInstance().getAllRatings(filmId)).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JSONObject(new RatingOperationResponse("Exeption retrieving all ratings", false)).toString();
		}
	}

	@Override
	public String getGlobalScore(String filmId) {
		// TODO Auto-generated method stub
		
		try {
			return new JSONObject(RatingUpdaterService.getInstance().getGlobalScore(filmId)).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JSONObject(new RatingOperationResponse("Exeption retrieving global score", false)).toString();
		}
	}

	@Override
	public void addRatingsAsync(int userId, String filmId, int filmDirectionRating, int actorsRating,
			int globalScoreRating, int dialoguesRating, int costumesRating, AsyncResponse asyncResponse) throws Exception {
		// TODO Auto-generated method stub
		
		UtilityMethods.consoleLog("exec of asynchronous addRatings method");
		
		new Thread() {
			public void run() {
				try {
					RatingData objToAdd = new RatingData(filmId, userId, filmDirectionRating, actorsRating, globalScoreRating, dialoguesRating, costumesRating);
					
					boolean done = RatingUpdaterService.getInstance().addRating(objToAdd);
					
					if (done) {
						RatingUpdaterService.getInstance().updateGlobalScore(objToAdd);
						String message = new RatingOperationResponse("Rating inserted and global score updated", true).getJSONResponse();
						Response response = Response.ok(message).type(MediaType.APPLICATION_JSON).build();
						UtilityMethods.consoleLog("Responding on background thread");
						asyncResponse.resume(response);
					}
					String message = new RatingOperationResponse("User has already inserted the ratings for the film", false).getJSONResponse();
					Response response = Response.ok(message).type(MediaType.APPLICATION_JSON).build();
					UtilityMethods.consoleLog("Responding on background thread");
					asyncResponse.resume(response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					String message = new RatingOperationResponse("Exception during add ratings", false).getJSONResponse();
					Response response = Response.ok(message).type(MediaType.APPLICATION_JSON).build();
					UtilityMethods.consoleLog("Responding on background thread");
					asyncResponse.resume(response);
				}
			}
		};
		
	}

}
