package net.greenbudget.db;

import net.greenbudget.db.methods.AddExpenses;
import net.greenbudget.db.methods.CreateNewUser;
import net.greenbudget.db.methods.DbConnection;
import net.greenbudget.db.methods.DeleteExpenses;
import net.greenbudget.db.methods.GetAccount;
import net.greenbudget.db.methods.UpdateExpenses;
import net.greenbudget.responseData.RegisterUser;
import net.greenbudget.responseData.UserExpenses;

public class Db implements Database {

    DbConnection connection;

    public Db(){
        connection = new DbConnection();
    }


    // Create a new user
    @Override
    public void NewUser(RegisterUser newUserForm){
        CreateNewUser newUser = CreateNewUser.getInstance();
        newUser.singleRecord(this.connection, newUserForm);
    }

    // get user account information
    @Override
    public void fetchAccount(String email){
        GetAccount getAccount = GetAccount.getInstance();
        System.out.println(getAccount.init(this.connection, email)); 
    }

    // add expenses
    @Override
    public void addExpenses(String userEmail, UserExpenses expenses){
        AddExpenses addExpenses = AddExpenses.getInstance();
        System.out.println(addExpenses.init(this.connection, userEmail, expenses));
    }

    // update expenses
    @Override
    public void updateExpenses(String newName, String userEmail, UserExpenses expenses){
        UpdateExpenses updateExpenses = UpdateExpenses.getInstance();
        System.out.println(updateExpenses.init(this.connection, newName, userEmail, expenses));
    }

    // delete expenses
    @Override
    public void deleteExpenses(String name, String userEmail){
        DeleteExpenses deleteExpenses = DeleteExpenses.getInstance();
        System.out.println(deleteExpenses.init(this.connection, name, userEmail));
    }

    public static void main(String[] args){
        var db = new Db();
        db.deleteExpenses("Light Bill","olivierjp06@outlook.com");
    }
    
}


