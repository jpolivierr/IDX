package com.hometrest.Api;

import java.io.IOException;

import com.hometrest.EndPoints.SimilarLisings;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig
public class SimilarListingsServlet extends HttpServlet {
      // set Header
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    resp.setHeader("Access-Control-Allow-Origin", "*");
    resp.setContentType("application/json");


         var similarListings = new SimilarLisings();
         similarListings.init(req, resp);
  
  
 }
}
