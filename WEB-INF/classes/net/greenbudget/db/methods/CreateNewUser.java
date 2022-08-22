package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.UserData;

public class CreateNewUser {

    private static CreateNewUser instance;

    private CreateNewUser(){}

    public static CreateNewUser getInstance(){
        return instance = instance == null ? new CreateNewUser() : null;
    }

    public String singleRecord(DbConnection dbConnection, UserData user){
        Connection connection = dbConnection.connect();
        String response =null;
        try {
            String query = new DbConfig().getQueryCreateNewUser();
            dbConnection.pstmt = connection.prepareStatement(query);
            dbConnection.pstmt.setString(1,  user.getFirstName());
            dbConnection.pstmt.setString(2, user.getlastName());
            dbConnection.pstmt.setString(3, user.getemail());                
            dbConnection.pstmt.setString(4, user.getpassword());
            dbConnection.pstmt.executeUpdate();
            //Create a responses
            var jsonResponse = new Response(200, "User Created", null);
            //assign response
                response = jsonResponse.send();
            
        } catch (SQLException e) {
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
