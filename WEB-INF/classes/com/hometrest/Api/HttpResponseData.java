package com.hometrest.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class HttpResponseData {

    private static HttpServletResponse resp;

    public HttpResponseData(HttpServletResponse resp){
        HttpResponseData.resp = resp;
    }

    public static void send(int status, String message, String data){
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        var jsonData = gson.toJson(data);
        // set Status Header
        resp.setStatus(status);

        var responseObj = new HashMap<>();
        responseObj.put("Status", status);
        responseObj.put("message", message);
        responseObj.put("data", data);
        
        
        String Json = gson.toJson(data);
        

        try {
            PrintWriter out = resp.getWriter();
            out.print(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
