package net.greenbudget.db.methods;

import java.sql.Connection;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.responseData.RegisterUser;

public class CreateNewUser {

    private static CreateNewUser instance;

    private CreateNewUser(){}

    public static CreateNewUser getInstance(){
        return instance = instance == null ? new CreateNewUser() : null;
    }

    public void singleRecord(DbConnection dbConnection, RegisterUser user){
        Connection connection = dbConnection.connect();
        try {
            String query = new DbConfig().getQueryCreateNewUser();
            dbConnection.pstmt = connection.prepareStatement(query);
            dbConnection.pstmt.setString(1,  user.getFirstName());
            dbConnection.pstmt.setString(2, user.getlastName());
            dbConnection.pstmt.setString(3, user.getemail());                
            dbConnection.pstmt.setString(4, user.getpassword());
            dbConnection.pstmt.executeUpdate();
            System.out.println("record inserted..");
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
