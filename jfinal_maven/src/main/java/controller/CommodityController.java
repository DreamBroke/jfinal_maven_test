package controller;

import interceptor.LoginInterceptor;

import java.util.List;

import model.Commodity;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;

@Before(LoginInterceptor.class)
public class CommodityController extends Controller {

    public void index() {
        List<Commodity> commodity;
        if(getPara("id") != null && !getPara("id").equals("")) {
            commodity = Commodity.dao.find("select * from commodity where id = ?", getPara("id"));
        } else {
            commodity = Commodity.dao.find("select * from commodity");
        }
        setAttr("list", commodity);
        renderJsp("index.jsp");
    }

    public void add() {
        if (getPara("id") != null) {
            Commodity commodity = Commodity.dao.findById(getPara("id"));
            setAttr("commodity", commodity);
            renderJsp("add.jsp");
            return;
        }
        Commodity commodity = getModel(Commodity.class);
        if (commodity.getStr("name") == null || commodity.getStr("name") == "") {
            renderJsp("add.jsp");
            return;
        }
        commodity.save();
        redirect("/hello");
    }

    public void delete() {
        Db.deleteById("commodity", getPara("id"));
        System.out.println("-------------" + getPara("id"));
        redirect("/hello");
    }

    public void update() {
        Db.update("update commodity set id=?,name=?,price=?,quantity=? where id=?", getPara("id"), getPara("commodity.name"), getPara("commodity.price"), getPara("commodity.quantity"), getPara("id"));
        redirect("/hello");
    }
}
