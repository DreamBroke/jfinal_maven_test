package config;

import model.Commodity;

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

public class Config extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        loadPropertyFile("dbconfig.properties");
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/hello", CommodityController.class);
    }

    @Override
    public void configEngine(Engine me) {
        
    }

    @Override
    public void configPlugin(Plugins me) {
        DruidPlugin dp = new DruidPlugin(getProperty("url"), getProperty("user"), getProperty("password"), getProperty("driver"));
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);
        arp.addMapping("commodity", Commodity.class);
    }

    @Override
    public void configInterceptor(Interceptors me) {
        
    }

    @Override
    public void configHandler(Handlers me) {
        
    }

}
