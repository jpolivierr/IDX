package net.greenbudget.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.greenbudget.Config.DbConfig;

public class accountServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
     
        var config = new DbConfig();

        resp.setHeader("Accress-Control-Allow-Origin", config.getHost());
        // String account = req.getParameter("account");
        resp.getWriter().println("there");

}
}
