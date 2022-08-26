package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;

public class DeleteTransaction {
    private static DeleteTransaction  instance;

    private DeleteTransaction(){}

    public static DeleteTransaction  getInstance(){
        return instance = instance == null ? new DeleteTransaction () : null;
    }

    public String init(DbConnection dbConnection, Integer transactionId, String userEmail){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryDeleteTransaction();

            //create prepare statement
            dbConnection.pstmt = connection.prepareStatement(query);

            dbConnection.pstmt.setInt(1, transactionId);
            dbConnection.pstmt.setString(2, userEmail); 
            
            dbConnection.pstmt.execute();

             //Create a responses
            var jsonResponse = new Response(200, "Expenses Deleted.", null);
            //assign response
                response = jsonResponse.send();

            
        }catch (SQLException e) {
            //Create a responses
            var jsonResponse = new Response(406, DbExceptionHandler.Message(e.getErrorCode(),e.getMessage()), null);

            //assign response
            response = jsonResponse.send();

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

        return response;
    }
}
