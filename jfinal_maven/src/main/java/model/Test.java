package model;

import com.jfinal.plugin.activerecord.Model;

public class Test extends Model<Test>{

    private static final long serialVersionUID = 6323632924589616459L;
    public static final Test dao = new Test().dao();

}
