package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.SQLException;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;

public class DeleteUser {
    private static DeleteUser instance;

    private DeleteUser(){}

    public static DeleteUser getInstance(){
        return instance = instance == null ? new DeleteUser() : null;
    }

    public String init(DbConnection dbConnection, String email){
        Connection connection = dbConnection.connect();
        String response = null;
        try {
            String query = new DbConfig().getQueryDeleteUser();
            dbConnection.pstmt = connection.prepareStatement(query);
            dbConnection.pstmt.setString(1,  email);
            dbConnection.pstmt.executeUpdate();
            var jsonResponse = new Response(200, "User deleted.", null);
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
