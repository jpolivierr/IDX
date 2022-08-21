package net.greenbudget.Config;
import io.github.cdimascio.dotenv.Dotenv;


public class DbConfig {

    private final  Dotenv dotenv = Dotenv.load();
    private final  String DB_USERNAME = dotenv.get("DB_USERNAME");
    private final  String DB_PWD = dotenv.get("DB_PWD");
    private final  String DB_DRIVER = dotenv.get("DB_DRIVER");
    private final  String DB_URL = dotenv.get("DB_URL");

    private final  String HOST = dotenv.get("HOST");

    private final String QUERY_GET_ACCOUNT = dotenv.get("QUERY_GET_ACCOUNT");
    private final String QUERY_ADD_EXPENSES = dotenv.get("QUERY_ADD_EXPENSES");
    private final String QUERY_CREATE_NEW_USER = dotenv.get("QUERY_CREATE_NEW_USER");
    private final String QUERY_UPDATE_EXPENSES = dotenv.get("QUERY_UPDATE_EXPENSES");

    public String getQueryUpdateExpenses(){
        return QUERY_UPDATE_EXPENSES ;
    }

    public String getQueryCreateNewUser(){
        return QUERY_CREATE_NEW_USER;
    }

    public String getQueryAddExpenses(){
        return QUERY_ADD_EXPENSES;
    }

    public String getQueryGetAccount(){
        return QUERY_GET_ACCOUNT;
    }

    public String getUsername(){
        return DB_USERNAME;
    }

    public String getPwd(){
        return DB_PWD;
    }

    public String getDriver(){
        return DB_DRIVER;
    }

    public String getUrl(){
        return DB_URL;
    }

    public String getHost(){
        return HOST;
    }

}
