package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;

public class CheckRecord {

    private CheckRecord(){}

    public static CheckRecord  getInstance(){
        return new CheckRecord ();
    }

    public Boolean init(DbConnection dbConnection,String type, String value){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;
        Boolean status = null;

        try {
            // get the Query string form .env
            String query = null;
            switch(type){
                case "user":
                    query = new DbConfig().getQueryConfirmUser();
                    break;
                case "exp":
                    query = new DbConfig().getQueryConfirmExp();
                default:
                    query = null; 
            }

             

            //create prepare statement
            dbConnection.pstmt = connection.prepareStatement(query);

            dbConnection.pstmt.setString(1, value);

            // get the result set from database
            var result = dbConnection.pstmt.executeQuery();

            if(result.next()){
                status = true;
            }else{
                status = false;
            }

            
        }catch (SQLException e) {
            //Create a responses
            var jsonResponse = new Response(406, DbExceptionHandler.Message(e.getErrorCode(),e.getMessage()), null);

            //assign response
            response = jsonResponse.send();
            e.printStackTrace();

       }catch(Exception e){
           //Create a responses
           var jsonResponse = new Response(406, e.getMessage(), null);

           //assign response
           response = jsonResponse.send();

       }finally{
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return status;
    }
}
