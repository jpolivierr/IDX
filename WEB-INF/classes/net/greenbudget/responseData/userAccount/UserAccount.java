package net.greenbudget.responseData.userAccount;

import java.util.HashMap;

import net.greenbudget.responseData.ResponseData;

public class UserAccount extends ResponseData {
 
    private HashMap<String,String> userInfo;

    public UserAccount(
                        UserInfo userInfo
                      )
                      {
        this.userInfo = userInfo.build();
    }
    
}
