package net.greenbudget.servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.greenbudget.db.Db;
import net.greenbudget.responseData.RegisterUserData;
import net.greenbudget.validator.InputValidator;

public class ProcessNewUser {

    public void init(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        var user = new RegisterUserData(firstName, lastName , email , password , password2);

        if(InputValidator.validate(user).length > 0){
                String[] list = InputValidator.validate(user);
                
                String param = Arrays.toString(list);
                param = param.substring(1, param.length()-1);
                String encArray = URLEncoder.encode(param, "utf-8");
                req.setAttribute("errorMessage", encArray);
                req.setAttribute("first_name", firstName);
                req.setAttribute("last_name", lastName);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/userRegister.jsp").forward(req, resp);
        }else{

                var db = new Db();
                db.NewUser(user);
                resp.sendRedirect("/green-budget/account.jsp");
        }


    }
    
}
