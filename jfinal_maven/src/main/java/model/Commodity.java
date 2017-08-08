package model;

import com.jfinal.plugin.activerecord.Model;

public class Commodity extends Model<Commodity> {

    /**
     * 
     */
    private static final long serialVersionUID = -839562708492767863L;

    public static final Commodity dao = new Commodity().dao();
    
}
