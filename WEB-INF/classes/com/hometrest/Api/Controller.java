package com.hometrest.Api;
import java.io.IOException;

import com.hometrest.MakeRequest.Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@MultipartConfig
public class Controller extends HttpServlet {
    // set Header
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
          resp.setHeader("Access-Control-Allow-Origin", "*");
          resp.setContentType("application/json");

       //    new HttpResponseData(resp);
       //    HttpResponseData.send(200, "success");

          var request = new Request();
            try {
              request.get(resp);
            } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
             }
   }
}
