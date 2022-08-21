package net.greenbudget.responseData.userAccount;

import java.util.HashMap;

public class UserInfo {

    private HashMap<String,String> userObj;
    private String firstName;
    private String lastName;
    private String email;

    public UserInfo(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        userObj = new HashMap<>();
    }

    public HashMap<String,String> build(){
        userObj.put("First Name", this.firstName);
        userObj.put("Last Name", this.lastName);
        userObj.put("email", this.email);
        return userObj;
    }
    
}
