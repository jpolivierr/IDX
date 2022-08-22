package net.greenbudget.db;

import net.greenbudget.responseData.UserData;
import net.greenbudget.responseData.UserExpenses;

public interface Database {

    public String NewUser(UserData form);

    public String updateUser(String newEmail, UserData user);

    public String deleteUser(String email);

    public String fetchAccount(String email);

    public String addExpenses(String email, UserExpenses expenses);

    public String updateExpenses(String newName, String email, UserExpenses expenses);

    public String deleteExpenses(String name, String email);

    
    
    
    // public void createTable(DbConnection dbConnection);

    // public void insertRecord(DbConnection dbConnection);

}
