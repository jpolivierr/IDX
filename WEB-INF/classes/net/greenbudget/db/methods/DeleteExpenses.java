package net.greenbudget.db.methods;

import java.sql.Connection;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.response.Response;

public class DeleteExpenses {
    private static DeleteExpenses instance;

    private DeleteExpenses(){}

    public static DeleteExpenses getInstance(){
        return instance = instance == null ? new DeleteExpenses() : null;
    }

    public String init(DbConnection dbConnection, String name, String userEmail){

        //Get the connection
        Connection connection = dbConnection.connect();
        String response = null;

        try {
            // get the Query string form .env
            String query = new DbConfig().getQueryDeleteExpenses();

            //create prepare statement
            dbConnection.pstmt = connection.prepareStatement(query);

            dbConnection.pstmt.setString(1, name);
            dbConnection.pstmt.setString(2, userEmail); 
            
            dbConnection.pstmt.execute();

            var jsonResponse = new Response(200, "Expenses Deleted.", null);
            //assign response
                response = jsonResponse.send();

            
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
