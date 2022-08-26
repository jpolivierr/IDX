package net.greenbudget.responseData;

public class UserTransaction extends ResponseData {

    private int transactionId;
    private String name;
    private String category;
    private String Date;
     private Double amount;
   

    public UserTransaction (
                          int transactionId,
                          String name,
                          String category,
                          String Date,
                          Double amount
                        ){
        this.transactionId = transactionId;
        this.name = name;
        this.category = category;
        this.Date = Date;
        this.amount = amount;
    }

    public Integer getTransactionId(){
        return this.transactionId;
    }

    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDate(){
        return this.Date;
    }

    public Double getAmount(){
        return this.amount;
    }

    
}
