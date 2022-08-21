package net.greenbudget.db.methods;

import java.sql.Connection;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.UserExpenses;

public class AddExpenses {
    
    private static AddExpenses instance;

    private AddExpenses(){}

    public static AddExpenses getInstance(){
        return instance = instance == null ? new AddExpenses() : null;
    }

    public String init(DbConnection dbConnection, String userEmail, UserExpenses expenses){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryAddExpenses();

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

            var jsonResponse = new Response(200, "Expenses added.", null);
            //assign response
                response = jsonResponse.send();

            
        } catch (Exception e) {

            var jsonResponse = new Response(300, e.getMessage(), null);
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
