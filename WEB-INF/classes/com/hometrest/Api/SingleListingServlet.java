package com.hometrest.Api;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import com.hometrest.EndPoints.SingleListing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig
public class SingleListingServlet extends HttpServlet {
          // set Header
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    resp.setHeader("Access-Control-Allow-Origin", "*");
    resp.setContentType("application/json");

         var singleListing = new SingleListing();
         singleListing.init(req, resp);

}
}
