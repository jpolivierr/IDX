package com.hometrest.EndPoints;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.hometrest.MakeRequest.Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SingleListing {

    

    public void init(HttpServletRequest req, HttpServletResponse resp, String payload) throws ServletException, IOException{

     //get the type of request
      String query = req.getQueryString();
         String url = "https://realty-in-us.p.rapidapi.com/properties/v3/detail?property_"+query;
         
        // try {
    
        //         Thread.sleep(1000);
        //         var fileName = Path.of("/opt/tomcat/web-hometrest/ROOT/WEB-INF/classes/com/hometrest/MakeRequest/demo_single.json");
        //         var demo = Files.readString(fileName); 
        //         var out = resp.getWriter();
        //         out.println(demo);
    
        // } catch (InterruptedException e) {
        //         e.printStackTrace();
        //    }
                  
    
      var request = new Request();
              try {
                request.get(resp, url);
              } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
               }
     }
    
}
