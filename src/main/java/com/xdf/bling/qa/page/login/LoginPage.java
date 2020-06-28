package com.xdf.bling.qa.page.login;

import com.xdf.bling.qa.page.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: LoginPage
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/15 6:51 下午
 */
public class LoginPage extends BasePage {

    public LoginPage (AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * 点击密码去登录tab
     */
    public void clickPasswordToLoginTab () {
        driver.findElementByXPath("//android.view.View[@text='密码登录']").click();
    }

    /**
     * 输入手机号
     * @param phone
     */
    public void setLoginMobileNumber (String phone) {
        MobileElement mobileElement = driver.findElementByXPath("//android.widget.EditText[@text='请输入报名手机号']");
        actionSendkeys(mobileElement, phone, false, false);
    }

    /**
     * 输入密码
     * @param password
     */
    public void setLoginPassword (String password) {
        MobileElement loginPasswordInput = driver.findElementByXPath("//android.widget.EditText[@text='请输入密码']");
        actionSendkeys(loginPasswordInput, password, false, false);
    }

    /**
     * 点击登录
     */
    public void clickLoginButton () {
        driver.findElementByXPath("//android.view.View[@text='登录']").click();
    }

    /**
     * 判断首页tab出现
     * @return
     */
    public boolean homePageTabIsExist () {
        MobileElement homePageElement = driver.findElementByXPath("//android.widget.ImageView[@text='首页\n" +
                "第 1 个标签，共 3 个']");
        return isPresent(homePageElement);
    }
}
