package it.univaq.disim.sose.data;

import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.riot.RDFDataMgr;

import it.univaq.disim.sose.model.RatingData;

public class RatingDataDAO_RDF implements RatingDataDAO {

	private static final String RATING_DATA = "rdf/rating_data.rdf";
	
	private Dataset loadDataset() {
		Dataset dataset = RDFDataMgr.loadDataset(RATING_DATA);
		dataset.begin(ReadWrite.READ);
		return dataset;
	}
	
	private String convertResultSetToJSONString(ResultSet resultSet) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(byteArrayOutputStream, resultSet);
		return byteArrayOutputStream.toString();
	}	
	
	@Override
	public boolean insertRatingData(RatingData toAdd) {
		// TODO Auto-generated method stub
		Dataset dataset = loadDataset();
		
		String toAddURI = "http://rankingdata/user" + toAdd.getUser_id() + "_film" + toAdd.getFilm_id();
		
		StringBuilder query = new StringBuilder();
		query.append("PREFIX cst: <http://customproperties/>").append(System.lineSeparator());
		
		query.append("INSERT DATA {").append(System.lineSeparator());
		query.append("	" + toAddURI + " cst:filmId " + toAdd.getFilm_id() + ".").append(System.lineSeparator());
		query.append("	" + toAddURI + " cst:userId " + toAdd.getUser_id() + ".").append(System.lineSeparator());
		query.append("	" + toAddURI + " cst:filmDirectionRating " + toAdd.getFilm_direction_rating() + ".").append(System.lineSeparator());
		query.append("	" + toAddURI + " cst:actorsRating " + toAdd.getActors_rating() + ".").append(System.lineSeparator());
		query.append("	" + toAddURI + " cst:globalScoreRating " + toAdd.getGlobal_score_rating() + ".").append(System.lineSeparator());
		query.append("	" + toAddURI + " cst:dialoguesRating " + toAdd.getDialogues_rating() + ".").append(System.lineSeparator());
		query.append("	" + toAddURI + " cst:costumesRating " + toAdd.getCostumer_rating() + ".").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		
		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		queryExecution.execConstruct();
		return false;
		
		/*
		 * Model model = ModelFactory.createDefaultModel();
		 * 
		 * String toAddURI = "http://rankingdata/user" + toAdd.getUser_id() + "_film" +
		 * toAdd.getFilm_id();
		 * 
		 * Resource resourceToAdd = model.createResource(toAddURI)
		 * .addProperty(model.createProperty("http://customproperties/filmId"),
		 * String.valueOf(toAdd.getFilm_id()))
		 * .addProperty(model.createProperty("http://customproperties/userId"),
		 * String.valueOf(toAdd.getUser_id())) .addProperty(model.createProperty(
		 * "http://customproperties/filmDirectionRating"),
		 * String.valueOf(toAdd.getFilm_direction_rating()))
		 * .addProperty(model.createProperty("http://customproperties/actorsRating"),
		 * String.valueOf(toAdd.getActors_rating()))
		 * .addProperty(model.createProperty("http://customproperties/globalScoreRating"
		 * ), String.valueOf(toAdd.getGlobal_score_rating()))
		 * .addProperty(model.createProperty("http://customproperties/dialoguesRating"),
		 * String.valueOf(toAdd.getDialogues_rating()))
		 * .addProperty(model.createProperty("http://customproperties/costumesRating"),
		 * String.valueOf(toAdd.getCostumer_rating()));
		 * 
		 * Model oldModel = ModelFactory.createDefaultModel(); oldModel.read(dataset);
		 * dataset.addNamedModel(toAddURI, oldModel)
		 * 
		 * return false;
		 */
	}

	@Override
	public boolean insertRatingDatas(List<RatingData> toAdd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RatingData> getAllRatingData() {
		// TODO Auto-generated method stub
		Dataset dataset = loadDataset();

		StringBuilder query = new StringBuilder();
		query.append("PREFIX cst: <http://customproperties/>").append(System.lineSeparator());
		query.append("SELECT ?film_id ?user_id ?film_direction_rating ?actors_rating ?global_score_rating ?dialogues_rating ?costumes_rating").append(System.lineSeparator());
		query.append("WHERE {").append(System.lineSeparator());
		query.append("	?rating_data cst:filmId ?film_id.").append(System.lineSeparator());
		query.append("	?rating_data cst:userId ?user_id.").append(System.lineSeparator());
		query.append("	?rating_data cst:filmDirectionRating ?film_direction_rating.").append(System.lineSeparator());
		query.append("	?rating_data cst:actorsRating ?actors_rating.").append(System.lineSeparator());
		query.append("	?rating_data cst:globalScoreRating ?global_score_rating.").append(System.lineSeparator());
		query.append("	?rating_data cst:dialoguesRating ?dialogues_rating.").append(System.lineSeparator());
		query.append("	?rating_data cst:costumesRating ?costumes_rating.").append(System.lineSeparator());
		query.append("}").append(System.lineSeparator());

		QueryExecution queryExecution = QueryExecutionFactory.create(query.toString(), dataset);
		ResultSet resultSet = queryExecution.execSelect();
		System.out.println(convertResultSetToJSONString(resultSet));
		return null;
	}

}
