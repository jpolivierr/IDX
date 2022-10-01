package net.greenbudget.db.methods;

public class DbExceptionHandler {

    public static String Message(int code, String message){
        switch(code){
            case 1062:
                return message+"code:"+ code +" Duplicate entry";
            case 1048:
                return message+"code:"+ code +"Entry cannot be empty";
            default :
                return message+"code:"+ code +"Something went wrong";
        }
    }
}
