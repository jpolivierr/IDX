package net.greenbudget.Config;
import io.github.cdimascio.dotenv.Dotenv;


public class DbConfig {

    private final  Dotenv dotenv = Dotenv.load();
    private final  String DB_USERNAME = dotenv.get("DB_USERNAME");
    private final  String DB_PWD = dotenv.get("DB_PWD");
    private final  String DB_DRIVER = dotenv.get("DB_DRIVER");
    private final  String DB_URL = dotenv.get("DB_URL");

    private final  String HOST = dotenv.get("HOST");


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
