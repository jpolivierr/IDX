package net.greenbudget.db;

import net.greenbudget.db.methods.AddExpenses;
import net.greenbudget.db.methods.CreateNewUser;
import net.greenbudget.db.methods.DbConnection;
import net.greenbudget.db.methods.DeleteExpenses;
import net.greenbudget.db.methods.DeleteUser;
import net.greenbudget.db.methods.GetAccount;
import net.greenbudget.db.methods.UpdateExpenses;
import net.greenbudget.db.methods.UpdateUser;
import net.greenbudget.responseData.UserData;
import net.greenbudget.responseData.UserExpenses;

public class Db implements Database {

    DbConnection connection;

    public Db(){
        connection = new DbConnection();
    }


    // Create a new user
    @Override
    public String NewUser(UserData newUserForm){
        CreateNewUser newUser = CreateNewUser.getInstance();
        return newUser.singleRecord(this.connection, newUserForm);
    }

    // Update user
    @Override
    public String updateUser(String newEmail, UserData user){
        var newUser = UpdateUser.getInstance();
        return newUser.init(this.connection, newEmail, user);
    }

    // Delete user
    @Override
    public String deleteUser(String email){
        var user = DeleteUser.getInstance();
        return user.init(this.connection, email);
    }

    // get user account information
    @Override
    public String fetchAccount(String email){
        GetAccount getAccount = GetAccount.getInstance();
        return getAccount.init(this.connection, email); 
    }

    // add expenses
    @Override
    public String addExpenses(String userEmail, UserExpenses expenses){
        AddExpenses addExpenses = AddExpenses.getInstance();
        return addExpenses.init(this.connection, userEmail, expenses);
    }

    // update expenses
    @Override
    public String updateExpenses(String newName, String userEmail, UserExpenses expenses){
        UpdateExpenses updateExpenses = UpdateExpenses.getInstance();
        return updateExpenses.init(this.connection, newName, userEmail, expenses);
    }

    // delete expenses
    @Override
    public String deleteExpenses(String name, String userEmail){
        DeleteExpenses deleteExpenses = DeleteExpenses.getInstance();
        return deleteExpenses.init(this.connection, name, userEmail);
    }

    public static void main(String[] args){
        var db = new Db();
        var user = new UserData("Frederic", "Olivier", null, "Carnaval2", null);
        System.out.println(db.deleteUser("jpolivie@gmail.com"));
    }
    
}
