package net.greenbudget.db;

import net.greenbudget.db.methods.CreateNewUser;
import net.greenbudget.db.methods.DbConnection;
import net.greenbudget.db.methods.GetAccount;
import net.greenbudget.responseData.Form;

public class Db implements Database {

    DbConnection connection;

    public Db(){
        connection = new DbConnection();
    }


    // Create a new user
    @Override
    public void NewUser(Form newUserForm){
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
    public void addExpenses(String expName, String email){

    }

    public static void main(String[] args){
        var db = new Db();
        db.fetchAccount("olivierjp06@outlook.com");
    }
    
}


