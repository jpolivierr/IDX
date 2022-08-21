package net.greenbudget.responseData;

import java.util.HashMap;

public class UserAccount extends ResponseData {
 
    private HashMap<String,String> userInfo;

    public UserAccount(
                        UserInfo userInfo
                      )
                      {
        this.userInfo = userInfo.build();
    }
    
}
