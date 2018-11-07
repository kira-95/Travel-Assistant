import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.squareup.okhttp.*;

import java.io.IOException;

public class GoogMatrixRequest {

    private static final String API_KEY = "AIzaSyA7fke7RjTcQI68ksEb9dpYGSEedWLwoGk";

  OkHttpClient client = new OkHttpClient();

  public String run(String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
        .build();

    Response response = client.newCall(request).execute();
    return response.body().string();
  }

  public static void main(String[] args) throws IOException {
    System.out.println(Distance("Metropolian Museum","Time Squre"));
    
  	}
  public static Double Distance(String A, String B) throws IOException{
	  GoogMatrixRequest request = new GoogMatrixRequest();
	    String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+A+"&destinations="+B+"&mode=bicycling&language=fr-FR&key=" + API_KEY;
	    String response = request.run(url_request);
	    JsonObject first = new Gson().fromJson(response, JsonObject.class);
	    JsonObject rows= (JsonObject) first.get("rows").getAsJsonArray().get(0);
	    JsonObject elements = (JsonObject) rows.get("elements").getAsJsonArray().get(0);
	    JsonObject distance = (JsonObject) elements.get("distance");
	    String actual_distance = distance.get("text").toString();
	    String Dnumber = actual_distance.substring(1, actual_distance.length()-3);
	    String temp = Dnumber.replaceAll(" ","");
	    String result = temp.replaceAll(",", ".");
	    System.out.println(result);
	    return Double.valueOf(result);
	  
  }
}