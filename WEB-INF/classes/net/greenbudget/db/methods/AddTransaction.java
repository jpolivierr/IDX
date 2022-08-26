package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;

public class AddTransaction {
     
    private static AddTransaction instance;

    private AddTransaction(){}

    public static AddTransaction getInstance(){
        return instance = instance == null ? new AddTransaction() : null;
    }

    public String init(DbConnection dbConnection, String userEmail, UserExpenses expenses){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryAddTransaction();

            //create prepare statement
            dbConnection.pstmt = connection.prepareStatement(query);

            dbConnection.pstmt.setString(1, expenses.getName());
            dbConnection.pstmt.setString(2, expenses.getFrequency());
            dbConnection.pstmt.setString(3, expenses.getCategory());
            dbConnection.pstmt.setString(4, expenses.getDueDate());
            dbConnection.pstmt.setDouble(5, expenses.getAmount());
            dbConnection.pstmt.setString(6, expenses.getClientDate());
            dbConnection.pstmt.setString(7, userEmail);  
            
            dbConnection.pstmt.execute();

            var jsonResponse = new Response(200, "Transaction added.", null);
            //assign response
                response = jsonResponse.send();

            
        } catch (SQLException e) {
            //Create a responses
            var jsonResponse = new Response(406, DbExceptionHandler.Message(e.getErrorCode(), e.getMessage()), null);

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
