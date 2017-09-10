package testModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import model.Account;
import model.Commodity;
import model.Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 * @author ilgqh
 *         JFinal的Model测试用例
 * 
 */
public class JFinalModelCase {
    
    private static String DB_DRIVER;
    
    private static String DB_URL;
    
    private static String DB_USERNAME;
    
    private static String DB_PASSWORD;
    
    private static DruidPlugin dp;
    
    private static ActiveRecordPlugin arp;
    
    static{
        Properties p = new Properties();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbconfig.properties");
        try {
            p.load(is);
            DB_DRIVER = p.getProperty("driver");
            DB_URL = p.getProperty("url");
            DB_USERNAME = p.getProperty("user");
            DB_PASSWORD = p.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void start() {
        dp = new DruidPlugin(DB_URL, DB_USERNAME, DB_PASSWORD, DB_DRIVER);
        dp.start();
        arp = new ActiveRecordPlugin(dp);
        arp.addMapping("commodity", Commodity.class);
        arp.addMapping("account", Account.class);
        arp.addMapping("test", Test.class);
        arp.start();
    }

    @AfterClass
    public static void stop() {
        arp.stop();
        dp.stop();
    }

}
