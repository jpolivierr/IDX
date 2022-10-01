package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.UserInfo;

public class GetUser {

    private static GetUser instance;

    private GetUser(){}

    public static GetUser getInstance(){
        return instance = instance == null ? new GetUser() : null;
    }

    public String init(DbConnection dbConnection, String userEmail){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryGetUser();

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

                var jsonResponse = new Response(200, "success", userInfo);
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
