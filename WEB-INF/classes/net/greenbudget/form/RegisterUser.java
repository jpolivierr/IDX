package net.greenbudget.form;

import java.util.HashMap;

public class RegisterUser implements Form {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String password2;
    private HashMap<String,String> allFields;

    public RegisterUser(String firstName,String lastName,String email,String password,String password2){
    
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.password2 = password2;
        this.allFields = addFields();

    }
    
    public String getFirstName(){
        return this.firstName;
    }

    public String getlastName(){
        return this.lastName;
    }

    public String getemail(){
        return this.email;
    }

    public String getpassword(){
        return this.password;
    }

    public String getpassword2(){
        return this.password2;
    }

    public HashMap<String,String> getAllFields(){
        return this.allFields;
    }

    public HashMap<String,String> addFields(){
        var fields = new HashMap<String,String>();
        fields.put("first_name", this.firstName);
        fields.put("last_name", this.lastName);
        fields.put("email", this.email);
        fields.put("password", this.password);
        fields.put("password2", this.password2);

        return fields;
    }
}
