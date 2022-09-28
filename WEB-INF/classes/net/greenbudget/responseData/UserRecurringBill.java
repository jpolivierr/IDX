package net.greenbudget.responseData;

import java.util.HashMap;

public class UserRecurringBill extends ResponseData {

    private String rcId;
    private String merchantName;
    private String frequency;
    private String category;
    private String dueDate;
    private Double amount;
    private String clientDate;
   

    public UserRecurringBill (
                          String rcId,
                          String merchantName,
                          String frequency,
                          String category,
                          String dueDate,
                          Double amount,
                          String clientDate
                        ){
        this.rcId = rcId;
        this.merchantName = merchantName;
        this.frequency = frequency;
        this.category = category;
        this.dueDate = dueDate;
        this.clientDate = clientDate;
        this.amount = amount;
    }

    public String getRcId(){
        return this.rcId;
    }

    public String getmerchantName(){
        return this.merchantName;
    }

    public String getFrequency(){
        return this.frequency;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public String getClientDate(){
        return this.clientDate;
    }

    public Double getAmount(){
        return this.amount;
    }
       

    
}
