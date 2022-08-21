package net.greenbudget.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

import net.greenbudget.responseData.Form;

public class InputValidator{

    public static String[] validate(Form user){

        var fields = user.getAllFields();
        ArrayList<String> report = new ArrayList<>();

        for(Map.Entry<String,String> field : fields.entrySet()){
            String key = field.getKey();
            String value = field.getValue();
            if(emptyField(key, value, report)){
             continue;
            }else{
                emailValidate(key, value, report);
                passwordMatch(fields, key, report);
            }
            
        }

        String[] errorList = report.toArray(new String[report.size()]);
        return errorList;
    }




    // check for empty fields
    public static Boolean emptyField(String key, String value, ArrayList<String> report){
        if(value == null || value.isEmpty()){
            String newKey = key.equals("password2") ? "password" : key;
            String cap = newKey.substring(0,1).toUpperCase() + newKey.substring(1);
            String finalName = cap.replace("_", " ");
            report.add(finalName+" cannot be Empty") ;
            return true;
        }else{
            return false;
        }
    }




    // validate email
    public static Boolean emailValidate(String key, String value, ArrayList<String> report){
        if(key == "email"){
            String regex = "^(.+)@(\\S+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);
            if(!matcher.matches()){
                report.add("Email is invalid") ;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }




    // validate password Matching
    public static void passwordMatch(HashMap<String,String> fields, String key, ArrayList<String> report){
        if(key.equals("password2") ){

            if(!fields.get("password").isEmpty() && !fields.get("password").isEmpty()){

                 if(!fields.get("password").equals(fields.get("password2"))){
                    report.add("Passwords do not match") ;

            }
           
        }
        }
    }

}