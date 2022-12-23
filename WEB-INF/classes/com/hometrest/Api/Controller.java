package com.hometrest.Api;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.hometrest.EndPoints.ListingResults;
import com.hometrest.EndPoints.SingleListing;
import com.hometrest.MakeRequest.Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@MultipartConfig
public class Controller extends HttpServlet {
    // set Header
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
          resp.setHeader("Access-Control-Allow-Origin", "*");
          resp.setContentType("application/json");

        //get data from client
        String payload = req.getParameter("formData");
        String urlPath = req.getRequestURI();

        // var listings = new ListingResults();
        //        listings.init(resp,payload);
              //  resp.getWriter().println(urlPath);

        switch(urlPath){
          case "/api/search" :
               var listings = new ListingResults();
               listings.init(resp,payload);
               break;
          case "/api/property" :
               var singleListing = new SingleListing();
               singleListing.init(req, resp,payload);
          break;
          default :
              resp.setStatus(404);
              resp.getWriter().println("{\"message\": page not found}");
        }
   }
}
