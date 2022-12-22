package com.hometrest.Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ListingResults {

    private int limit;
    private int offset;
    private String postal_code;
    private String[] type;
    private Beds beds;
    private String location;
    private SearchType searchType;

    private ListingResults(Builder builder){
        this.limit = builder.limit;
        this.offset = builder.offset;
        this.location = builder.location;
        this.searchType = builder.searchType;
        this.postal_code = builder.postal_code;
        this.type = builder.type;
        this.beds = builder.beds;
        
    }

    //setters and getters

        public String getLocation(){
            return location;
        }

        public SearchType getSearchType(){
            return searchType;
        }

    // beds class

    public static class Beds{
        private  int min;
        private  int max;

        public Beds(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    // SearchType class

    public static class SearchType {
        private  Boolean rent;
        private  Boolean buy;

        public SearchType(Boolean rent, Boolean buy){
            this.rent = rent;
            this.buy = buy;
        }
    }

    

    //Builder class

    public static class Builder {
        private int limit;
        private int offset;
        private String postal_code;
        private String[] type;
        private Beds beds;
        private String location;
        private SearchType searchType;


        public Builder(String location, SearchType searchType){
            this.location = location;
            this.searchType = searchType;
        }

        public Builder limit(int limit){
            this.limit = limit;
            return this;
        }

        public Builder offset(int offset){
            this.offset = offset;
            return this;
        }

        public Builder postalCode(String postal_code){
            this.postal_code = postal_code;
            return this;
        }

        public Builder type(String[] type){
            this.type = type;
            return this;
        }

        public Builder beds(Beds beds){
            this.beds = beds;
            return this;
        }

        public String build(){
            var listingResults = new ListingResults(this);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            var json = gson.toJson(listingResults);
            return json;
        }
    }

    
}
