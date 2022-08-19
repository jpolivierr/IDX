package net.greenbudget.db;

import net.greenbudget.db.methods.CreateNewUser;
import net.greenbudget.db.methods.DbConnection;
import net.greenbudget.form.Form;

public class Db implements Database {

    DbConnection connection;

    public Db(){
        connection = new DbConnection();
    }

    @Override
    public void NewUser(Form newUserForm){
        CreateNewUser newUser = CreateNewUser.getInstance();
        newUser.singleRecord(this.connection, newUserForm);
    }

    
}
