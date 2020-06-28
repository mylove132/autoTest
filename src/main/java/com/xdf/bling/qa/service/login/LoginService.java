package com.xdf.bling.qa.service.login;

import com.xdf.bling.qa.bean.Login;
import com.xdf.bling.qa.page.login.LoginPage;
import org.testng.Assert;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: LoginService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/15 7:13 下午
 */
public class LoginService {

    private final LoginPage loginPage;

    public LoginService (LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    /**
     * 登录操作
     * @param login
     */
    public void login (Login login) {
        loginPage.clickPasswordToLoginTab();
        loginPage.setLoginMobileNumber(login.getPhone());
        loginPage.setLoginPassword(login.getPassword());
        loginPage.clickLoginButton();
    }

    /**
     * 断言登录成功
     */
    public void assertLoginSuccess () {
        Assert.assertTrue(loginPage.homePageTabIsExist(), "期望登录成功后首页tab出现");
    }
}
