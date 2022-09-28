package net.greenbudget.servlets;

import java.io.IOException;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.greenbudget.Config.DbConfig;
import net.greenbudget.db.Db;
import net.greenbudget.responseData.UserRecurringBill;

@MultipartConfig 
public class RecurringBillServlet extends HttpServlet {

    Db db = new Db();
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
     
        var config = new DbConfig();

        resp.setHeader("Access-Control-Allow-Origin", config.getHost());
        String formData = req.getParameter("formData");
        var gson = new Gson();

        // UserRecurringBill.builType newjson = gson.fromJson(formData, UserRecurringBill.builType.class);

        // String responseData = db.addRecurringBill("jpolivier@gmail.com", recurringBill);
 
 
 
        // resp.getWriter().println(gson.toJson(newjson) ); 
        //   var recurringBill = new UserRecurringBill(
        //                                             rcId,
        //                                             merchantName,
        //                                             frequency,
        //                                             category,
        //                                             date,
        //                                             amount,
        //                                             clientDate


        //  );

               
        //  String rcId = req.getParameter("rcId");
        //  String merchantName = req.getParameter("merchantName");
        //  String category = req.getParameter("category");
        //  double amount = Double.parseDouble(req.getParameter("amount"));
        //  String frequency = req.getParameter("frequency");
        //  String date = req.getParameter("date");
        //  String clientDate = req.getParameter("clientDate");

        //  var recurringBill = new UserRecurringBill(
        //                                             rcId,
        //                                             merchantName,
        //                                             frequency,
        //                                             category,
        //                                             date,
        //                                             amount,
        //                                             clientDate


        //  );

                 

  }

}