package net.greenbudget.responseData;

import java.util.HashMap;

public class UserAccount extends ResponseData {
 
    private UserInfo userInfo;

    public UserAccount(
                        UserInfo userInfo
                      )
                      {
        this.userInfo = userInfo;
    }
    
}
