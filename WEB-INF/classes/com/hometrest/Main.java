package com.hometrest;

import com.hometrest.Api.ListingResultsServlet;
import com.hometrest.Api.PropertyServlet;
import com.hometrest.Api.SearchServlet;
import com.hometrest.Api.SimilarListingsServlet;
import com.hometrest.Api.SingleListingServlet;

public class Main{
        public static void main(String[] args){

                //  new Controller();
                 new ListingResultsServlet();
                 new SimilarListingsServlet();
                 new SingleListingServlet();
                 new SearchServlet();
                 new PropertyServlet();
         
        }
}