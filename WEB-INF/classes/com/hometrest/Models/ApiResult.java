package com.hometrest.Models;

public class ApiResult {
    private int limit = 50;
    private int offset = 0;
    private String state_code;
    private String postal_code;
    private String city;
    private String[] type;
    private Beds beds;
    private Baths baths;
    private ListPrice list_price;

    // beds class

    public static class Beds{
        private  int min;
        private  int max;
    }

     // baths class

     public static class Baths{
        private  int min;
        private  int max;
    }

    // List price class

    public static class ListPrice {
        private  int min;
        private  int max;
    }

  

}
