package net.greenbudget.db.methods;

import java.sql.Connection;

import net.greenbudget.responseData.Form;

public class CreateNewUser {

    private static CreateNewUser instance;

    private CreateNewUser(){}

    public static CreateNewUser getInstance(){
        return instance = instance == null ? new CreateNewUser() : null;
    }

    public void singleRecord(DbConnection dbConnection, Form form){
        Connection connection = dbConnection.connect();
        try {
            String query = "INSERT INTO gb_users(first_name, last_name, email, password)VALUES("+
            "?,?,?,?)";
            var formFields = form.getAllFields();
            dbConnection.pstmt = connection.prepareStatement(query);
            dbConnection.pstmt.setString(1, formFields.get("first_name") );
            dbConnection.pstmt.setString(2, formFields.get("last_name"));
            dbConnection.pstmt.setString(3, formFields.get("email"));                
            dbConnection.pstmt.setString(4, formFields.get("password"));
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
