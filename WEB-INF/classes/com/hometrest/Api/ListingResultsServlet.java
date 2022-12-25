package com.hometrest.Api;
import java.io.IOException;

import com.hometrest.EndPoints.ListingResults;
import com.hometrest.EndPoints.SingleListing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@MultipartConfig
public class ListingResultsServlet extends HttpServlet {
    // set Header
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
          resp.setHeader("Access-Control-Allow-Origin", "*");
          resp.setContentType("application/json");

        //get data from client
        String payload = req.getParameter("formData");

        // var listings = new ListingResults();
        //        listings.init(resp,payload);
              //  resp.getWriter().println(urlPath);

               var listings = new ListingResults();
               listings.init(resp,payload);
      
   }
}
