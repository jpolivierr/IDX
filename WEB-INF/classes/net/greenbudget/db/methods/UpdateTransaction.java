package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.UserTransaction;

public class UpdateTransaction {

    private static UpdateTransaction instance;

    private UpdateTransaction(){}

    public static UpdateTransaction getInstance(){
        return instance = instance == null ? new UpdateTransaction() : null;
    }

    public String init(DbConnection dbConnection, String email, UserTransaction transaction){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryUpdateTransaction();

            //create prepare statement
            dbConnection.pstmt = connection.prepareStatement(query);

            dbConnection.pstmt.setString(1, transaction.getName());
            dbConnection.pstmt.setString(2, transaction.getDate());
            dbConnection.pstmt.setString(3, transaction.getCategory());
            dbConnection.pstmt.setDouble(4, transaction.getAmount());
            dbConnection.pstmt.setString(5, email);
            dbConnection.pstmt.setInt(6, transaction.getTransactionId());
            
            dbConnection.pstmt.execute();

            var jsonResponse = new Response(200, "Expenses updated.", null);
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
