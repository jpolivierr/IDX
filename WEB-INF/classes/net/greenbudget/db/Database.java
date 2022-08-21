package net.greenbudget.db;

import net.greenbudget.responseData.RegisterUser;
import net.greenbudget.responseData.UserExpenses;

public interface Database {

    public void NewUser(RegisterUser form);

    public void fetchAccount(String email);

    public void addExpenses(String email, UserExpenses expenses);

    public void updateExpenses(String newName, String email, UserExpenses expenses);

    public void deleteExpenses(String name, String email);
    
    // public void createTable(DbConnection dbConnection);

    // public void insertRecord(DbConnection dbConnection);

}
