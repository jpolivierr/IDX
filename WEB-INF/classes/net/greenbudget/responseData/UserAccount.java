package net.greenbudget.responseData;


public class UserAccount extends ResponseData {
 
    private UserInfo userInfo;

    public UserAccount(
                        UserInfo userInfo
                      )
                      {
        this.userInfo = userInfo;
    }
    
}
