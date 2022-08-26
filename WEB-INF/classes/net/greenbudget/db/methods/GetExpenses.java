package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.UserExpenses;

public class GetExpenses {
    private static GetExpenses instance;

    private GetExpenses(){}

    public static GetExpenses getInstance(){
        return instance = instance == null ? new GetExpenses() : null;
    }

    public String init(DbConnection dbConnection, String userEmail){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryGetExpenses();

            //create prepare statement
            dbConnection.pstmt = connection.prepareStatement(query);

            dbConnection.pstmt.setString(1, userEmail);                
            // get the result set from database
            var result = dbConnection.pstmt.executeQuery();

            while(result.next()){

                String expName = result.getString("exp_name");
                String expFrequency = result.getString("exp_frequency");
                String expCategory = result.getString("exp_category");
                String expDueDate = result.getString("exp_due_date");
                Double expAmount = result.getDouble("exp_amount");

                var userExpenses = new UserExpenses(expName, expFrequency, expCategory, expDueDate, expAmount, null);
                var jsonResponse = new Response(200, "success", userExpenses);
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
