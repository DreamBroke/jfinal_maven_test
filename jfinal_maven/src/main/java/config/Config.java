package config;

import interceptor.LoginInterceptor;
import model.Account;
import model.Commodity;
import model.Test;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

import controller.CommodityController;
import controller.EngineTestController;
import controller.IndexController;
import controller.LoginController;

public class Config extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/", IndexController.class);
        me.add("/hello", CommodityController.class);
        me.add("/login", LoginController.class);
        me.add("/test", EngineTestController.class);
    }

    @Override
    public void configEngine(Engine me) {
        //me.addSharedFunction("common/footer.html");
    }

    @Override
    public void configPlugin(Plugins me) {
        loadPropertyFile("dbconfig.properties");
        DruidPlugin dp = new DruidPlugin(getProperty("url"), getProperty("user"), getProperty("password"), getProperty("driver"));
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);
        arp.addMapping("commodity", Commodity.class);
        arp.addMapping("account", Account.class);
        arp.addMapping("test", Test.class);
    }

    @Override
    public void configInterceptor(Interceptors me) {
        me.add(new LoginInterceptor());
    }

    @Override
    public void configHandler(Handlers me) {
        
    }

}
