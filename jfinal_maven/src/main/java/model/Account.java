package model;

import com.jfinal.plugin.activerecord.Model;

public class Account extends Model<Account> {

    private static final long serialVersionUID = 3560085175822243301L;
    public static final Account dao = new Account().dao();
    
}
