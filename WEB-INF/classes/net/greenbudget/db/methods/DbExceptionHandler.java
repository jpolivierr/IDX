package net.greenbudget.db.methods;

public class DbExceptionHandler {

    public static String Message(int code, String message){
        switch(code){
            case 1062:
                return message+" Duplicate entry";
            case 1048:
                return "Entry cannot be empty";
            default :
                return "Something went wrong";
        }
    }
}
