package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.RegisterUserData;

public class UpdateUser {
    
    private static UpdateUser instance;

    private UpdateUser(){}

    public static UpdateUser getInstance(){
        return instance = instance == null ? new UpdateUser() : null;
    }

    public String init(DbConnection dbConnection, String newEmail, RegisterUserData user){
        Connection connection = dbConnection.connect();
        String response = null;
        try {
            String query = new DbConfig().getQueryUpdateUser();
            dbConnection.pstmt = connection.prepareStatement(query);
            dbConnection.pstmt.setString(1,  user.getFirstName());
            dbConnection.pstmt.setString(2, user.getlastName());
            dbConnection.pstmt.setString(3, newEmail);                
            dbConnection.pstmt.setString(4, user.getemail());
            dbConnection.pstmt.executeUpdate();


            var jsonResponse = new Response(200, "User updated.", null);
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
