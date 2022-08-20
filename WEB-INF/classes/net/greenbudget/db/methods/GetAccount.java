package net.greenbudget.db.methods;

import java.sql.Connection;

import net.greenbudget.Config.DbConfig;

public class GetAccount {

    private static GetAccount instance;

    private GetAccount(){}

    public static GetAccount getInstance(){
        return instance = instance == null ? new GetAccount() : null;
    }

    public void init(DbConnection dbConnection, String email){

        //Get the connection
        Connection connection = dbConnection.connect();

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryGetAccount();

            //create prepare statement
            dbConnection.pstmt = connection.prepareStatement(query);

            dbConnection.pstmt.setString(1, email);                
            // get the result set from database
            var result = dbConnection.pstmt.executeQuery();

            while(result.next()){
                System.out.println(result.getString("first_name"));
            }

            
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
