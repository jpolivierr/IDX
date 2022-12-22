package com.hometrest.Api;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.hometrest.MakeRequest.Request;
import com.hometrest.Models.ListingResults;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@MultipartConfig
public class Controller extends HttpServlet {
    // set Header
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
          resp.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
          resp.setContentType("application/json");

        //get data from client
        String payload = req.getParameter("formData");

        try {
          Thread.sleep(1000);

              var fileName = Path.of("/opt/tomcat/web-hometrest/ROOT/WEB-INF/classes/com/hometrest/MakeRequest/demo.json");
              var demo = Files.readString(fileName); 
              var out = resp.getWriter();

        out.println(demo);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        

    // var request = new Request();
          //   try {
          //     request.post(resp, payload );
          //   } catch (InterruptedException e) {
          //     // TODO Auto-generated catch block
          //     e.printStackTrace();
          //    }
   }
}
