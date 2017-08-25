package interceptor;

import util.AccountValidate;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class LoginSuccessInterceptor implements Interceptor {

    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        if (AccountValidate.isRightAccount(controller.getCookie("username"), controller.getCookie("password"))) {
            controller.redirect("/hello");
            return;
        }
        inv.invoke();
    }

}
