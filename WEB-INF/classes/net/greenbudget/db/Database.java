package net.greenbudget.db;

import net.greenbudget.form.Form;

public interface Database {

    public void NewUser(Form form);

    public void fetchAccount(String email);

    public void addExpenses(String expName, String userEmail);
    
    // public void createTable(DbConnection dbConnection);

    // public void insertRecord(DbConnection dbConnection);

}
