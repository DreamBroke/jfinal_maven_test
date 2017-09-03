package controller;

import java.util.List;

import model.Commodity;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

@Clear
public class EngineTestController extends Controller{
    
    public void index() {
        List<Commodity> commodityList = Commodity.dao.find("select * from commodity");
        Commodity commodity = Commodity.dao.find("select * from commodity where id = 14").get(0);
        setAttr("commodity", commodity);
        setAttr("commodityList", commodityList);
        render("test.html");
    }
    
}
