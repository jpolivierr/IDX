package net.greenbudget.db;

import net.greenbudget.Config.DbConfig;
import net.greenbudget.db.methods.AddExpenses;
import net.greenbudget.db.methods.CheckRecord;
import net.greenbudget.db.methods.CreateNewUser;
import net.greenbudget.db.methods.DbConnection;
import net.greenbudget.db.methods.DeleteExpenses;
import net.greenbudget.db.methods.DeleteUser;
import net.greenbudget.db.methods.GetAccount;
import net.greenbudget.db.methods.GetUser;
import net.greenbudget.db.methods.UpdateExpenses;
import net.greenbudget.db.methods.UpdateUser;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.RegisterUserData;
import net.greenbudget.responseData.UserExpenses;

public class Db implements Database {

    private DbConnection connection;
    private CheckRecord checkRecord;

    public Db(){
        connection = new DbConnection();
        checkRecord = CheckRecord.getInstance();
    }

    // Check a new user
    public boolean checkRecord(String type, String value){
        return checkRecord.init(this.connection, type, value);
    }

    // Create a new user
    @Override
    public String NewUser(RegisterUserData newUserForm){
        CreateNewUser newUser = CreateNewUser.getInstance();
        return newUser.singleRecord(this.connection, newUserForm);
    }

    // fetch user
    @Override
    public String fetchUser(String userEmail){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            var newUser = GetUser.getInstance();
        return newUser.init(this.connection, userEmail);
        }
    }

    // Update user
    @Override
    public String updateUser(String newEmail, RegisterUserData user){
        if(!checkRecord("user", user.getemail())){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            var newUser = UpdateUser.getInstance();
            return newUser.init(this.connection, newEmail, user);
        }
    }

    // Delete user
    @Override
    public String deleteUser(String userEmail){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            var user = DeleteUser.getInstance();
           return user.init(this.connection, userEmail);
        }
    }

    // get user account information
    @Override
    public String fetchAccount(String email){
        if(!checkRecord("user", email)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            GetAccount getAccount = GetAccount.getInstance();
        return getAccount.init(this.connection, email); 
        }
    }

    // add expenses
    @Override
    public String addExpenses(String userEmail, UserExpenses expenses){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            AddExpenses addExpenses = AddExpenses.getInstance();
           return addExpenses.init(this.connection, userEmail, expenses);
        }
        
    }

    // update expenses
    @Override
    public String updateExpenses(String newName, String userEmail, UserExpenses expenses){

        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            UpdateExpenses updateExpenses = UpdateExpenses.getInstance();
        return updateExpenses.init(this.connection, newName, userEmail, expenses);
        }

        
    }

    // delete expenses
    @Override
    public String deleteExpenses(String name, String userEmail){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            DeleteExpenses deleteExpenses = DeleteExpenses.getInstance();
            return deleteExpenses.init(this.connection, name, userEmail);
        }
        
    }

    public static void main(String[] args){
        var db = new Db();
        var user = new RegisterUserData("Karine", "Olivier", "kne@gmail.com", "Carnaval2", null);

        //chech record
        System.out.println(db.checkRecord("user", "jpolivier@gmail.com"));
        
        //create user
        // System.out.println(db.NewUser(user));

         //fetch user 
        //  System.out.println(db.fetchUser("karineolivier@gmail.com"));

        //update user 
        // System.out.println(db.updateUser("karineolivier@gmail.com", user));

        //Delete user
        // System.out.println(db.deleteUser("jpolivierr@gmailcom"));
    }

}