package com.hometrest.EndPoints;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;

import com.hometrest.Api.HttpResponseData;
import com.hometrest.MakeRequest.Request;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SingleListing {

        private final  Dotenv dotenv = Dotenv.load();
    private final String REALTOR_API_KEY = dotenv.get("REALTOR_API_KEY");

    

    public void init(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

     //get the type of request
      String query = req.getQueryString();
         String url = "https://realty-in-us.p.rapidapi.com/properties/v3/detail?property_"+query;

        try {
    
                Thread.sleep(1000);
                var fileName = Path.of("/opt/tomcat/web-hometrest/ROOT/WEB-INF/classes/com/hometrest/MakeRequest/demo_single.json");
                var demo = Files.readString(fileName); 
                var out = resp.getWriter();
                out.println(demo);
    
        } catch (InterruptedException e) {
                e.printStackTrace();
           }
                  


                // try {
                //         get(resp, url);
                // } catch (InterruptedException e) {
                //         // TODO Auto-generated catch block
                //         e.printStackTrace();
                // }
         
        }

//********************************************************** */
// Make Request
//********************************************************** */


public void get(HttpServletResponse resp, String url)throws IOException, InterruptedException {
        

        HttpClient client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("accept", "application/json")
                        .header("X-RapidAPI-Key", REALTOR_API_KEY )
                        .header("X-RapidAPI-Host", "realty-in-us.p.rapidapi.com")
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();
  
        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
  
        new HttpResponseData();
          try {
            HttpResponseData.send(resp, 200, "success",response.get().body());
          } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
  
    }
    
}
