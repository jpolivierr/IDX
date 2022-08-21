package net.greenbudget.db.methods;

import java.sql.Connection;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.userAccount.UserAccount;
import net.greenbudget.responseData.userAccount.UserInfo;

public class GetAccount {

    private static GetAccount instance;

    private GetAccount(){}

    public static GetAccount getInstance(){
        return instance = instance == null ? new GetAccount() : null;
    }

    public String init(DbConnection dbConnection, String userEmail){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryGetAccount();

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
