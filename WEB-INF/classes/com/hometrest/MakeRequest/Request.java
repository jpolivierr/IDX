package com.hometrest.MakeRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.hometrest.Api.HttpResponseData;

import jakarta.servlet.http.HttpServletResponse;

import io.github.cdimascio.dotenv.Dotenv;

public class Request {

     private final  Dotenv dotenv = Dotenv.load();
     private final String REALTOR_API_KEY = dotenv.get("REALTOR_API_KEY");


    public void post(HttpServletResponse resp, String payload)throws IOException, InterruptedException {
        

        HttpClient client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                        .uri(URI.create("https://realty-in-us.p.rapidapi.com/properties/v3/list"))
                        .header("accept", "application/json")
                        .header("X-RapidAPI-Key", REALTOR_API_KEY )
                        .header("X-RapidAPI-Host", "realty-in-us.p.rapidapi.com")
                        .method("POST", HttpRequest.BodyPublishers.ofString(payload))
                        .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        new HttpResponseData(resp);
          HttpResponseData.send(200, "sucess",response.body());

    }


   
}
