package net.greenbudget.responseData;

public class UserTransaction extends ResponseData {

    private int transactionId;
    private String merchantName;
    private String category;
    private String date;
     private Double amount;
   

    public UserTransaction (
                          int transactionId,
                          String merchantName,
                          String category,
                          String date,
                          Double amount
                        ){
        this.transactionId = transactionId;
        this.merchantName = merchantName;
        this.category = category;
        this.date = date;
        this.amount = amount;
    }

    public Integer getTransactionId(){
        return this.transactionId;
    }

    public String getMerchantName(){
        return this.merchantName;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDate(){
        return this.date;
    }

    public Double getAmount(){
        return this.amount;
    }

    
}
