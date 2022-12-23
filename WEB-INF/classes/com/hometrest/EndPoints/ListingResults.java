package com.hometrest.EndPoints;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;

public class ListingResults {

    private String url = "https://realty-in-us.p.rapidapi.com/properties/v3/list";

    public void init(HttpServletResponse resp, String payload) throws ServletException, IOException{

    try {

            Thread.sleep(1000);
            var fileName = Path.of("/opt/tomcat/web-hometrest/ROOT/WEB-INF/classes/com/hometrest/MakeRequest/demo.json");
            var demo = Files.readString(fileName); 
            var out = resp.getWriter();
            out.println(demo);

    } catch (InterruptedException e) {
            e.printStackTrace();
       }
      

  // var request = new Request();
        //   try {
        //     request.send(resp, "POST", url, payload );
        //   } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        //    }
 }
    

}
