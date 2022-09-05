package net.greenbudget;

import net.greenbudget.servlets.*;

public class Main {

    public static void main(String[] args){
         new RegisterServlet();
         new AccountServlet();
         new RecurringBillServlet();
    }
    
}
