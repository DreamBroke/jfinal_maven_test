package util;

import java.util.List;

import model.Account;

public class AccountValidate {

    public static boolean isRightAccount(String username, String password) {
        if (username == null || password == null || username.equals("") || password.equals("")) {
            return false;
        }
        List<Account> account = Account.dao.find("select * from account where username = '" + username + "' and password = '" + password + "';");
        if (account == null || account.size() != 1) {
            return false;
        }
        return true;
    }
    
}
