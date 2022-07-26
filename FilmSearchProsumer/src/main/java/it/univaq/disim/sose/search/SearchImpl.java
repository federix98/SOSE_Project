package it.univaq.disim.sose.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import it.univaq.disim.sose.search.model.Result;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class SearchImpl implements Search {

	private String API_KEY = "k_dm7b3skf";

/*
	public List<Result> searchFilmsByName(String a) {
		//String imdb ="{\"searchType\":\"Title\",\"expression\":\"La mummia\",\"results\":[{\"id\":\"tt0120616\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BOTJiYjBhZDgtMjhiOC00MTIzLThlNGMtMmI1NjIwM2M3YTI5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1999) aka \\\"La mummia\\\"\"},{\"id\":\"tt2345759\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTkwMTgwODAxMl5BMl5BanBnXkFtZTgwNTEwNTQ3MDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(2017) aka \\\"La mummia\\\"\"},{\"id\":\"tt0053085\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BN2M3NzlkZTItYTFmZS00Y2RhLThlYTYtYTk1YjJiOTZiYWQyXkEyXkFqcGdeQXVyMTE2NzA0Ng@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1959) aka \\\"La mummia\\\"\"},{\"id\":\"tt0209163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjE2NzU1NTk2MV5BMl5BanBnXkFtZTgwMjIwMzcxMTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy Returns\",\"description\":\"(2001) aka \\\"La mummia - Il ritorno\\\"\"},{\"id\":\"tt0859163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTU4NDIzMDY1OV5BMl5BanBnXkFtZTcwNjQxMzk3MQ@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy: Tomb of the Dragon Emperor\",\"description\":\"(2008) aka \\\"La mummia - La tomba dell'Imperatore Dragone\\\"\"},{\"id\":\"tt0023245\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjEyNTIzNzcyMV5BMl5BanBnXkFtZTgwOTgwODY2MTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1932) aka \\\"La mummia\\\"\"},{\"id\":\"tt0064703\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNzQ1M2IwMTUtM2VlYi00Y2Q4LTlmYmQtM2EwMWJhNjM1MjU1XkEyXkFqcGdeQXVyMjI4NzAzNjg@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1969) aka \\\"La mummia\\\"\"},{\"id\":\"tt0050718\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNjc2YTlkZjctNWFjMC00MzQzLWIxZmQtMjRlZmM3YTc4NGE3XkEyXkFqcGdeQXVyMTQ2MjQyNDc@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Aztec Mummy\",\"description\":\"(1957) aka \\\"Il risveglio della mummia\\\"\"},{\"id\":\"tt20032882\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/nopicture.jpg\",\"title\":\"Wonder Woman + La Mummia\",\"description\":\"(2017) (Podcast Episode) - FantascientifiCast (2012) (Podcast Series)\"}],\"errorMessage\":\"\"}";
		String urlImdb="https://imdb-api.com/API/Search/k_dm7b3skf/" + a;
		List<Result> results = new ArrayList<Result> (); 

		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url(urlImdb)
				  .method("GET", null)
				  .build();
				try {
					ResponseBody response = client.newCall(request).execute().body();
					results  = arrayFilmsGenerator(response.string());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return results;
	}  
*/
	public List<Result> searchFilmsByName(String a) throws IOException {
		String imdb ="{\"searchType\":\"Title\",\"expression\":\"La mummia\",\"results\":[{\"id\":\"tt0120616\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BOTJiYjBhZDgtMjhiOC00MTIzLThlNGMtMmI1NjIwM2M3YTI5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1999) aka \\\"La mummia\\\"\"},{\"id\":\"tt2345759\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTkwMTgwODAxMl5BMl5BanBnXkFtZTgwNTEwNTQ3MDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(2017) aka \\\"La mummia\\\"\"},{\"id\":\"tt0053085\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BN2M3NzlkZTItYTFmZS00Y2RhLThlYTYtYTk1YjJiOTZiYWQyXkEyXkFqcGdeQXVyMTE2NzA0Ng@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1959) aka \\\"La mummia\\\"\"},{\"id\":\"tt0209163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjE2NzU1NTk2MV5BMl5BanBnXkFtZTgwMjIwMzcxMTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy Returns\",\"description\":\"(2001) aka \\\"La mummia - Il ritorno\\\"\"},{\"id\":\"tt0859163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTU4NDIzMDY1OV5BMl5BanBnXkFtZTcwNjQxMzk3MQ@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy: Tomb of the Dragon Emperor\",\"description\":\"(2008) aka \\\"La mummia - La tomba dell'Imperatore Dragone\\\"\"},{\"id\":\"tt0023245\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjEyNTIzNzcyMV5BMl5BanBnXkFtZTgwOTgwODY2MTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1932) aka \\\"La mummia\\\"\"},{\"id\":\"tt0064703\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNzQ1M2IwMTUtM2VlYi00Y2Q4LTlmYmQtM2EwMWJhNjM1MjU1XkEyXkFqcGdeQXVyMjI4NzAzNjg@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1969) aka \\\"La mummia\\\"\"},{\"id\":\"tt0050718\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNjc2YTlkZjctNWFjMC00MzQzLWIxZmQtMjRlZmM3YTc4NGE3XkEyXkFqcGdeQXVyMTQ2MjQyNDc@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Aztec Mummy\",\"description\":\"(1957) aka \\\"Il risveglio della mummia\\\"\"},{\"id\":\"tt20032882\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/nopicture.jpg\",\"title\":\"Wonder Woman + La Mummia\",\"description\":\"(2017) (Podcast Episode) - FantascientifiCast (2012) (Podcast Series)\"}],\"errorMessage\":\"\"}";

		List<Result> results = new ArrayList<Result> (); 
		results  = arrayFilmsGenerator(imdb);
       
		return results;
		} 
	

	@Override
	public List<Result> searchOnlyFilms(String a) {
		//String imdb ="{\"searchType\":\"Title\",\"expression\":\"La mummia\",\"results\":[{\"id\":\"tt0120616\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BOTJiYjBhZDgtMjhiOC00MTIzLThlNGMtMmI1NjIwM2M3YTI5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1999) aka \\\"La mummia\\\"\"},{\"id\":\"tt2345759\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTkwMTgwODAxMl5BMl5BanBnXkFtZTgwNTEwNTQ3MDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(2017) aka \\\"La mummia\\\"\"},{\"id\":\"tt0053085\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BN2M3NzlkZTItYTFmZS00Y2RhLThlYTYtYTk1YjJiOTZiYWQyXkEyXkFqcGdeQXVyMTE2NzA0Ng@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1959) aka \\\"La mummia\\\"\"},{\"id\":\"tt0209163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjE2NzU1NTk2MV5BMl5BanBnXkFtZTgwMjIwMzcxMTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy Returns\",\"description\":\"(2001) aka \\\"La mummia - Il ritorno\\\"\"},{\"id\":\"tt0859163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTU4NDIzMDY1OV5BMl5BanBnXkFtZTcwNjQxMzk3MQ@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy: Tomb of the Dragon Emperor\",\"description\":\"(2008) aka \\\"La mummia - La tomba dell'Imperatore Dragone\\\"\"},{\"id\":\"tt0023245\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjEyNTIzNzcyMV5BMl5BanBnXkFtZTgwOTgwODY2MTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1932) aka \\\"La mummia\\\"\"},{\"id\":\"tt0064703\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNzQ1M2IwMTUtM2VlYi00Y2Q4LTlmYmQtM2EwMWJhNjM1MjU1XkEyXkFqcGdeQXVyMjI4NzAzNjg@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1969) aka \\\"La mummia\\\"\"},{\"id\":\"tt0050718\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNjc2YTlkZjctNWFjMC00MzQzLWIxZmQtMjRlZmM3YTc4NGE3XkEyXkFqcGdeQXVyMTQ2MjQyNDc@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Aztec Mummy\",\"description\":\"(1957) aka \\\"Il risveglio della mummia\\\"\"},{\"id\":\"tt20032882\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/nopicture.jpg\",\"title\":\"Wonder Woman + La Mummia\",\"description\":\"(2017) (Podcast Episode) - FantascientifiCast (2012) (Podcast Series)\"}],\"errorMessage\":\"\"}";
		String urlImdb="https://imdb-api.com/en/API/SearchMovie/" + API_KEY + "/" + a;
		List<Result> results = new ArrayList<Result> (); 

		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url(urlImdb)
				  .method("GET", null)
				  .build();
				try {
					ResponseBody response = client.newCall(request).execute().body();
					results  = arrayFilmsGenerator(response.string());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return results;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Result> searchOnlySeries(String a) {
		String urlImdb="https://imdb-api.com/en/API/SearchSeries/" + API_KEY + "/" + a;
		List<Result> results = new ArrayList<Result> (); 

		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url(urlImdb)
				  .method("GET", null)
				  .build();
				try {
					ResponseBody response = client.newCall(request).execute().body();
					results  = arrayFilmsGenerator(response.string());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return results;		
	}

	@Override
	public List<Result> searchEpisodes(String a) {
		String urlImdb="https://imdb-api.com/en/API/SearchEpisode/" + API_KEY + "/" + a;
		List<Result> results = new ArrayList<Result> (); 

		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url(urlImdb)
				  .method("GET", null)
				  .build();
				try {
					ResponseBody response = client.newCall(request).execute().body();
					results  = arrayFilmsGenerator(response.string());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return results;	
	}
	
	
	
	
	/* Just to reuse code */
	private List<Result> arrayFilmsGenerator(String imdb) {
		JSONObject json = new JSONObject(imdb);
		JSONArray jsonArray = json.getJSONArray("results");
		List<Result> results = new ArrayList<Result> (); 

        for (int i = 0; i < jsonArray.length(); i++) {  
            // store each object in JSONObject  
            JSONObject x = jsonArray.getJSONObject(i);  
        	Result result = new Result(x.getString("id"), x.getString("description"),x.getString("title"),x.getString("image"));
        	results.add(result);
        }      
        
		return results;
	}

}
	