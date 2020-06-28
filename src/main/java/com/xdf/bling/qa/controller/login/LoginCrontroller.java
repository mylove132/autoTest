package com.xdf.bling.qa.controller.login;

import com.xdf.bling.qa.bean.Login;
import com.xdf.bling.qa.controller.BaseController;
import com.xdf.bling.qa.page.login.LoginPage;
import com.xdf.bling.qa.service.login.LoginService;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: LoginCrontroller
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/15 7:18 下午
 */
@Feature("登录场景")
public class LoginCrontroller extends BaseController {

    @Test(description = "测试手机号和密码登录", dataProvider = "providerMethod")
    public void testLogin (Map<String, String> param) {
        LoginPage loginPage = new LoginPage(super.driver);
        LoginService loginService = new LoginService(loginPage);
        Login login = new Login();
        login.setPhone(param.get("phone"));
        login.setPassword(param.get("password"));
        loginService.login(login);
        loginService.assertLoginSuccess();
    }

}
