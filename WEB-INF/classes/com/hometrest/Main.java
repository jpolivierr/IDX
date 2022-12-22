package com.hometrest;

import com.google.gson.Gson;
import com.hometrest.Api.Controller;
import com.hometrest.Models.ApiResult;
import com.hometrest.Models.ListingResults;

public class Main{
        public static void main(String[] args){

                 new Controller();
                 Gson gson = new Gson();
                 var json = gson.toJson(new ApiResult());

                 System.out.println(json);
         
        }
}