package net.greenbudget.db;

import net.greenbudget.db.methods.AddExpenses;
import net.greenbudget.db.methods.CreateNewUser;
import net.greenbudget.db.methods.DbConnection;
import net.greenbudget.db.methods.GetAccount;
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

    public static void main(String[] args){
        var db = new Db();
        var expenses = new UserExpenses("Rent", "monthly", "bill","2022:09:01 12:00:00","2022:08:20 12:00:00", 956.00);
        db.addExpenses("olivierjp06@outlook.com", expenses);;
    }
    
}


