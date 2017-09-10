package testModel;

import java.util.List;

import model.Account;
import model.Commodity;

import org.junit.Test;

public class ModelTest extends JFinalModelCase {

    @Test
    public void testGetAllCommodity() {
        List<Commodity> list = Commodity.dao.find("select * from commodity");
        for (Commodity commodity : list) {
            System.out.println(commodity);
        }
    }

    @Test
    public void testGetAccountById() {
        Account account = Account.dao.findById(1);
        System.out.println(account);
    }

    @Test
    public void testTestById() {
        model.Test t = model.Test.dao.findById(1);
        System.out.println(t);
    }

}
