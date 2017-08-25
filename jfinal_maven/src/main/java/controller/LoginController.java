package controller;

import interceptor.LoginSuccessInterceptor;
import util.AccountValidate;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class LoginController extends Controller {

    @Before(LoginSuccessInterceptor.class)
    public void index() {
        renderJsp("login.jsp");
    }
    
    public void login() {
        String username = getPara("username");
        String password = getPara("password");
        if (!AccountValidate.isRightAccount(username, password)) {
            setAttr("msg", "用户名和密码输入错误，请重新输入！");
            renderJsp("login.jsp");
            return;
        }
        setCookie("username", username, 60 * 5);
        setCookie("password", password, 60 * 5);
        redirect("/hello");
    }
    
}
