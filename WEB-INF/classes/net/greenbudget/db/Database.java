package net.greenbudget.db;

import net.greenbudget.responseData.RegisterUserData;
import net.greenbudget.responseData.UserExpenses;

public interface Database {

    public String NewUser(RegisterUserData form);

    public String fetchUser(String form);

    public String updateUser(String newEmail, RegisterUserData user);

    public String deleteUser(String email);

    public String fetchAccount(String email);

    public String addExpenses(String email, UserExpenses expenses);

    public String fetchExpenses(String userEmail);

    public String updateExpenses(String newName, String email, UserExpenses expenses);

    public String deleteExpenses(String name, String email);

    
    
    
    // public void createTable(DbConnection dbConnection);

    // public void insertRecord(DbConnection dbConnection);

}
