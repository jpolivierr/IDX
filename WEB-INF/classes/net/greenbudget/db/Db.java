package net.greenbudget.db;

import net.greenbudget.db.methods.AddRecurringBill;
import net.greenbudget.db.methods.CheckRecord;
import net.greenbudget.db.methods.AddNewUser;
import net.greenbudget.db.methods.AddTransaction;
import net.greenbudget.db.methods.DbConnection;
import net.greenbudget.db.methods.DeleteRecurringBill;
import net.greenbudget.db.methods.DeleteTransaction;
import net.greenbudget.db.methods.DeleteUser;
import net.greenbudget.db.methods.GetAccount;
import net.greenbudget.db.methods.GetRecurringBill;
import net.greenbudget.db.methods.GetTransactions;
import net.greenbudget.db.methods.GetUser;
import net.greenbudget.db.methods.UpdateRecurringBill;
import net.greenbudget.db.methods.UpdateTransaction;
import net.greenbudget.db.methods.UpdateUser;
import net.greenbudget.response.Response;
import net.greenbudget.responseData.RegisterUserData;
import net.greenbudget.responseData.UserRecurringBill;
import net.greenbudget.responseData.UserTransaction;

public class Db{

    private DbConnection connection;
    private CheckRecord checkRecord;
    private GetUser newUser = GetUser.getInstance();

    public Db(){
        connection = new DbConnection();
        checkRecord = CheckRecord.getInstance();
    }

    // Check a new user
    public boolean checkRecord(String type, String value){
        return checkRecord.init(this.connection, type, value);
    }

    // Create a new user
    // @Override
    public String NewUser(RegisterUserData newUserForm){
        AddNewUser newUser = AddNewUser.getInstance();
        return newUser.singleRecord(this.connection, newUserForm);
    }

    // fetch user
    // @Override
    public String fetchUser(String userEmail){
        
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            return newUser.init(this.connection, userEmail);
        }
    }

    // Update user
    // @Override
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
    // @Override
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
    // @Override
    public String fetchAccount(String email){
        if(!checkRecord("user", email)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            GetAccount getAccount = GetAccount.getInstance();
        return getAccount.init(this.connection, email); 
        }
    }

    // add recurring bill
    // @Override
    public String addRecurringBill(String userEmail, UserRecurringBill recurringBill){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            AddRecurringBill addRecurringBill = AddRecurringBill.getInstance();
           return addRecurringBill.init(this.connection, userEmail, recurringBill);
        }
    }

    // get recurring bill
    // @Override
    public String fetchRecurringBill(String userEmail){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            var addRecurringBill = GetRecurringBill.getInstance();
           return addRecurringBill.init(this.connection, userEmail);
        }
    }

    // update recuring bill
    // @Override
    public String updateRecurringBill(String newName, String userEmail, UserRecurringBill recurringBill){

        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            UpdateRecurringBill updateRecurringBill = UpdateRecurringBill.getInstance();
        return updateRecurringBill.init(this.connection, newName, userEmail, recurringBill);
        }

        
    }

    // delete recurring bill
    // @Override
    public String deleteRecurringBill(String name, String userEmail){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            DeleteRecurringBill deleteRecurringBill = DeleteRecurringBill.getInstance();
            return deleteRecurringBill.init(this.connection, name, userEmail);
        }
    }


    // Add transaction
    public String addTransaction(Integer transactionId, String userEmail,UserTransaction transaction){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            var addTransaction = AddTransaction.getInstance();
            return addTransaction.init(this.connection,transactionId, userEmail, transaction);
        }
    }


    // update transaction
    public String updateTransaction(String userEmail,UserTransaction transaction){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            var updateTransaction = UpdateTransaction.getInstance();
            return updateTransaction.init(this.connection, userEmail, transaction);
        }
    }


    // fetch transaction
    public String fetchTransaction(String userEmail){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            var getTransaction = GetTransactions.getInstance();
           return getTransaction.init(this.connection, userEmail);
        }
    } 

    // Delete transaction
    public String deleteTransaction(Integer transactionId, String userEmail){
        if(!checkRecord("user", userEmail)){
            var response = new Response(404, "Not fround", null).send();
            return response;
        }else{
            var deleteTransaction = DeleteTransaction.getInstance();
            return deleteTransaction.init(this.connection, transactionId, userEmail);
        }
    }

    public static void main(String[] args){
        var db = new Db();
        // var user = new RegisterUserData("Fredeic", "Olivier", "jpolivier@gmail.com", "Carnaval2", null);

        //chech record
        // System.out.println(db.checkRecord("user", "jpolivier@gmail.com"));
        
        //create user
        // System.out.println(db.NewUser(user));

         //fetch user 
         //System.out.println(db.fetchUser("karineolivier@gmail.com"));

        //update user 
        //System.out.println(db.updateUser("jpolivier@gmail.com", user));

        //Delete user
        //System.out.println(db.deleteUser("karineoli@gmail.com"));

        //Add recurringBill
        // var recurringBill = new UserrecurringBill("School", "Every 3 months", "Bills & Utilities", "2022:10:03", 950.45, null);
        // System.out.println(db.addRecurringBill("jpolivier@gmail.com", recurringBill));

        //Update recurringBill
        // var recurringBill = new UserrecurringBill("Education", "Every month", "Education", "2022:10:03", 150.45, null);
        // System.out.println(db.updateRecurringBill("Education","jpolivier@gmail.com", recurringBill));

        //Fetch recurringBill
        //  System.out.println(db.fetchRecurringBill("jpolivier@gmail.com"));

        //Delete recurringBill
        // System.out.println(db.deleteRecurringBill("Bill", "jpolivier@gmail.com"));

        //Add Transaction
        // var transaction = new UserTransaction(234, "food", "Groceries", "2022:08:24", 19.99);
        // System.out.println(db.addTransaction(2343, "jpolivier@gmail.com", transaction));

        //Update Transaction
        //  var transaction = new UserTransaction(234, "Food", "Groceries", "2022:08:24", 19.99);
        // System.out.println(db.updateTransaction("jpolivier@gmail.com", transaction));

        //fetch Transaction
        // System.out.println(db.fetchTransaction("jpolivier@gmail.com"));

        //Delete Transaction
        // System.out.println(db.deleteTransaction(0, "jpolivier@gmail.com"));
    }


}