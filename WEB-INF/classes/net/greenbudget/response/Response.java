package net.greenbudget.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.greenbudget.responseData.ResponseData;

public class Response {

    private int status;
    private String message;
    private ResponseData data;

    public Response(int status, String message, ResponseData responseData){
        this.status = status;
        this.message = message;
        this.data = responseData;
    }

    public String send(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String Json = gson.toJson(this);
        return Json;
    }

    
}
