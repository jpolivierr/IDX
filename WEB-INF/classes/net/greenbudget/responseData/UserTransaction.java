package net.greenbudget.responseData;

public class UserTransaction {
    private String name;
    private String category;
    private String Date;
     private Double amount;
   

    public UserTransaction (
                          String name,
                          String category,
                          String Date,
                          Double amount
                        ){
        this.name = name;
        this.category = category;
        this.Date = Date;
        this.amount = amount;
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
