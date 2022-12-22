package com.hometrest;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.hometrest.Api.Controller;
import com.hometrest.Models.ApiResult;
import com.hometrest.Models.ListingResults;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main{
        public static void main(String[] args){

                 new Controller();
                 try {
                        var fileName = Path.of("/opt/tomcat/web-hometrest/ROOT/WEB-INF/classes/com/hometrest/MakeRequest/demo.json");
                        var obj = Files.readString(fileName);      
                        System.out.println(obj);

                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
         
        }
}