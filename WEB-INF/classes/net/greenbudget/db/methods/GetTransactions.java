package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.UserTransaction;

public class GetTransactions {

    private static GetTransactions instance;

    private GetTransactions(){}

    public static GetTransactions getInstance(){
        return instance = instance == null ? new GetTransactions() : null;
    }

    public String init(DbConnection dbConnection, String userEmail){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryGetTransactions();

            //create prepare statement
            dbConnection.pstmt = connection.prepareStatement(query);

            dbConnection.pstmt.setString(1, userEmail);                
            // get the result set from database
            var result = dbConnection.pstmt.executeQuery();

            while(result.next()){

                String tsName = result.getString("ts_name");
                String tsCategory = result.getString("ts_category");
                Double tsAmount = result.getDouble("ts_amount");
                String tsDate = result.getString("ts_date");
                Integer tsId = result.getInt("transactionId");

                var userTransaction = new UserTransaction(tsId, tsName, tsCategory, tsDate, tsAmount);
                var jsonResponse = new Response(200, "success", userTransaction);
                response = jsonResponse.send();
            }
            
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
