package net.greenbudget.responseData;

public class UserExpenses extends ResponseData {

    private String name;
    private String frequency;
    private String category;
    private String dueDate;
     private Double amount;
    private String clientDate;
   

    public UserExpenses (
                          String name,
                          String frequency,
                          String category,
                          String dueDate,
                          Double amount,
                          String clientDate
                        ){
        this.name = name;
        this.frequency = frequency;
        this.category = category;
        this.dueDate = dueDate;
        this.clientDate = clientDate;
        this.amount = amount;
    }

    public String getName(){
        return this.name;
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
