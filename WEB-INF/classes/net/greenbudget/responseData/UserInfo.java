package net.greenbudget.responseData;

import java.util.HashMap;

public class UserInfo extends ResponseData{

    private String firstName;
    private String lastName;
    private String email;

    public UserInfo(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
}
