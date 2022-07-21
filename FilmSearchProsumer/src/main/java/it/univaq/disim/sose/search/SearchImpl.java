package it.univaq.disim.sose.search;

import java.io.IOException;
import org.json.JSONObject;
import org.json.XML;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class SearchImpl implements Search {


	public String searchFilmsByName(String a) {
		//String imdb ="{\"searchType\":\"Title\",\"expression\":\"La mummia\",\"results\":[{\"id\":\"tt0120616\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BOTJiYjBhZDgtMjhiOC00MTIzLThlNGMtMmI1NjIwM2M3YTI5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1999) aka \\\"La mummia\\\"\"},{\"id\":\"tt2345759\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTkwMTgwODAxMl5BMl5BanBnXkFtZTgwNTEwNTQ3MDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(2017) aka \\\"La mummia\\\"\"},{\"id\":\"tt0053085\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BN2M3NzlkZTItYTFmZS00Y2RhLThlYTYtYTk1YjJiOTZiYWQyXkEyXkFqcGdeQXVyMTE2NzA0Ng@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1959) aka \\\"La mummia\\\"\"},{\"id\":\"tt0209163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjE2NzU1NTk2MV5BMl5BanBnXkFtZTgwMjIwMzcxMTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy Returns\",\"description\":\"(2001) aka \\\"La mummia - Il ritorno\\\"\"},{\"id\":\"tt0859163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTU4NDIzMDY1OV5BMl5BanBnXkFtZTcwNjQxMzk3MQ@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy: Tomb of the Dragon Emperor\",\"description\":\"(2008) aka \\\"La mummia - La tomba dell'Imperatore Dragone\\\"\"},{\"id\":\"tt0023245\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjEyNTIzNzcyMV5BMl5BanBnXkFtZTgwOTgwODY2MTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1932) aka \\\"La mummia\\\"\"},{\"id\":\"tt0064703\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNzQ1M2IwMTUtM2VlYi00Y2Q4LTlmYmQtM2EwMWJhNjM1MjU1XkEyXkFqcGdeQXVyMjI4NzAzNjg@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1969) aka \\\"La mummia\\\"\"},{\"id\":\"tt0050718\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNjc2YTlkZjctNWFjMC00MzQzLWIxZmQtMjRlZmM3YTc4NGE3XkEyXkFqcGdeQXVyMTQ2MjQyNDc@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Aztec Mummy\",\"description\":\"(1957) aka \\\"Il risveglio della mummia\\\"\"},{\"id\":\"tt20032882\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/nopicture.jpg\",\"title\":\"Wonder Woman + La Mummia\",\"description\":\"(2017) (Podcast Episode) - FantascientifiCast (2012) (Podcast Series)\"}],\"errorMessage\":\"\"}";
		String urlImdb="https://imdb-api.com/API/Search/k_dm7b3skf/" + a;
		String xml="";
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url(urlImdb)
				  .method("GET", null)
				  .build();
				try {
					ResponseBody response = client.newCall(request).execute().body();
					JSONObject json = new JSONObject(response.string());
					xml = XML.toString(json);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		System.out.println(xml);
		return xml;
	} 

	/*public String searchFilmsByName(String a) {
		String imdb ="{\"searchType\":\"Title\",\"expression\":\"La mummia\",\"results\":[{\"id\":\"tt0120616\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BOTJiYjBhZDgtMjhiOC00MTIzLThlNGMtMmI1NjIwM2M3YTI5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1999) aka \\\"La mummia\\\"\"},{\"id\":\"tt2345759\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTkwMTgwODAxMl5BMl5BanBnXkFtZTgwNTEwNTQ3MDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(2017) aka \\\"La mummia\\\"\"},{\"id\":\"tt0053085\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BN2M3NzlkZTItYTFmZS00Y2RhLThlYTYtYTk1YjJiOTZiYWQyXkEyXkFqcGdeQXVyMTE2NzA0Ng@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1959) aka \\\"La mummia\\\"\"},{\"id\":\"tt0209163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjE2NzU1NTk2MV5BMl5BanBnXkFtZTgwMjIwMzcxMTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy Returns\",\"description\":\"(2001) aka \\\"La mummia - Il ritorno\\\"\"},{\"id\":\"tt0859163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTU4NDIzMDY1OV5BMl5BanBnXkFtZTcwNjQxMzk3MQ@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy: Tomb of the Dragon Emperor\",\"description\":\"(2008) aka \\\"La mummia - La tomba dell'Imperatore Dragone\\\"\"},{\"id\":\"tt0023245\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjEyNTIzNzcyMV5BMl5BanBnXkFtZTgwOTgwODY2MTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1932) aka \\\"La mummia\\\"\"},{\"id\":\"tt0064703\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNzQ1M2IwMTUtM2VlYi00Y2Q4LTlmYmQtM2EwMWJhNjM1MjU1XkEyXkFqcGdeQXVyMjI4NzAzNjg@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1969) aka \\\"La mummia\\\"\"},{\"id\":\"tt0050718\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNjc2YTlkZjctNWFjMC00MzQzLWIxZmQtMjRlZmM3YTc4NGE3XkEyXkFqcGdeQXVyMTQ2MjQyNDc@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Aztec Mummy\",\"description\":\"(1957) aka \\\"Il risveglio della mummia\\\"\"},{\"id\":\"tt20032882\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/nopicture.jpg\",\"title\":\"Wonder Woman + La Mummia\",\"description\":\"(2017) (Podcast Episode) - FantascientifiCast (2012) (Podcast Series)\"}],\"errorMessage\":\"\"}";
		String xml="";
		JSONObject json = new JSONObject(imdb);
		xml = XML.toString(json);
		System.out.println(xml);
		return xml;
		} */
	
	@Override
	public String searchOnlyFilms(String a) {
		//String imdb ="{\"searchType\":\"Title\",\"expression\":\"La mummia\",\"results\":[{\"id\":\"tt0120616\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BOTJiYjBhZDgtMjhiOC00MTIzLThlNGMtMmI1NjIwM2M3YTI5XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1999) aka \\\"La mummia\\\"\"},{\"id\":\"tt2345759\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTkwMTgwODAxMl5BMl5BanBnXkFtZTgwNTEwNTQ3MDI@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(2017) aka \\\"La mummia\\\"\"},{\"id\":\"tt0053085\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BN2M3NzlkZTItYTFmZS00Y2RhLThlYTYtYTk1YjJiOTZiYWQyXkEyXkFqcGdeQXVyMTE2NzA0Ng@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1959) aka \\\"La mummia\\\"\"},{\"id\":\"tt0209163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjE2NzU1NTk2MV5BMl5BanBnXkFtZTgwMjIwMzcxMTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy Returns\",\"description\":\"(2001) aka \\\"La mummia - Il ritorno\\\"\"},{\"id\":\"tt0859163\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMTU4NDIzMDY1OV5BMl5BanBnXkFtZTcwNjQxMzk3MQ@@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy: Tomb of the Dragon Emperor\",\"description\":\"(2008) aka \\\"La mummia - La tomba dell'Imperatore Dragone\\\"\"},{\"id\":\"tt0023245\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BMjEyNTIzNzcyMV5BMl5BanBnXkFtZTgwOTgwODY2MTE@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1932) aka \\\"La mummia\\\"\"},{\"id\":\"tt0064703\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNzQ1M2IwMTUtM2VlYi00Y2Q4LTlmYmQtM2EwMWJhNjM1MjU1XkEyXkFqcGdeQXVyMjI4NzAzNjg@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Mummy\",\"description\":\"(1969) aka \\\"La mummia\\\"\"},{\"id\":\"tt0050718\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/MV5BNjc2YTlkZjctNWFjMC00MzQzLWIxZmQtMjRlZmM3YTc4NGE3XkEyXkFqcGdeQXVyMTQ2MjQyNDc@._V1_Ratio0.7273_AL_.jpg\",\"title\":\"The Aztec Mummy\",\"description\":\"(1957) aka \\\"Il risveglio della mummia\\\"\"},{\"id\":\"tt20032882\",\"resultType\":\"Title\",\"image\":\"https://imdb-api.com/images/original/nopicture.jpg\",\"title\":\"Wonder Woman + La Mummia\",\"description\":\"(2017) (Podcast Episode) - FantascientifiCast (2012) (Podcast Series)\"}],\"errorMessage\":\"\"}";
		String urlImdb="https://imdb-api.com/en/API/SearchMovie/k_dm7b3skf/" + a;
		String xml="";
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url(urlImdb)
				  .method("GET", null)
				  .build();
				try {
					ResponseBody response = client.newCall(request).execute().body();
					JSONObject json = new JSONObject(response.string());
					xml = XML.toString(json);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		System.out.println(xml);
		return xml;
		// TODO Auto-generated method stub
	}

	@Override
	public String searchOnlySeries(String a) {
		String urlImdb="https://imdb-api.com/en/API/SearchSeries/k_dm7b3skf/" + a;
		String xml="";
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url(urlImdb)
				  .method("GET", null)
				  .build();
				try {
					ResponseBody response = client.newCall(request).execute().body();
					JSONObject json = new JSONObject(response.string());
					xml = XML.toString(json);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		System.out.println(xml);
		return xml;		
	}

	@Override
	public String searchEpisodes(String a) {
		String urlImdb="https://imdb-api.com/en/API/SearchEpisode/k_dm7b3skf/" + a;
		String xml="";
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url(urlImdb)
				  .method("GET", null)
				  .build();
				try {
					ResponseBody response = client.newCall(request).execute().body();
					JSONObject json = new JSONObject(response.string());
					xml = XML.toString(json);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		System.out.println(xml);
		return xml;	
	}
}
	