package net.greenbudget.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.greenbudget.Config.DbConfig;
import net.greenbudget.db.Db;

public class AccountServlet extends HttpServlet {

    Db db = new Db();
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
     
        var config = new DbConfig();

         resp.setHeader("Access-Control-Allow-Origin", config.getHost());
         
         var userAccount = db.fetchUser("jpolivier@gmail.com");
        resp.getWriter().println(userAccount);

}
}
