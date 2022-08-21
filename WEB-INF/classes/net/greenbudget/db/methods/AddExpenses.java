package net.greenbudget.db.methods;

import java.sql.Connection;

import net.greenbudget.Config.DbConfig;

public class AddExpenses {
    
    private static AddExpenses instance;

    private AddExpenses(){}

    public static AddExpenses getInstance(){
        return instance = instance == null ? new AddExpenses() : null;
    }

    public String init(DbConnection dbConnection,String expName, String userEmail){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryAddExpenses();

            //create prepare statement
            dbConnection.pstmt = connection.prepareStatement(query);

            dbConnection.pstmt.setString(1, userEmail);                
            // get the result set from database
            var result = dbConnection.pstmt.executeQuery();

            while(result.next()){

                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email= result.getString("email");

                var userInfo = new UserInfo(firstName, lastName, email);
                var userAccount = new UserAccount(userInfo);
                var jsonResponse = new Response(200, "success", userAccount);
                response = jsonResponse.send();
            }

            
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
