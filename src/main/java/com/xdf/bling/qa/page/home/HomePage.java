package com.xdf.bling.qa.page.home;

import com.xdf.bling.qa.page.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: HomePage
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/16 4:06 下午
 */
public class HomePage extends BasePage {

    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * 点击首页tab
     */
    public void clickHomePageTab () {
        MobileElement homePageElement = driver.findElementByXPath("//android.widget.ImageView[@text='首页\n" +
                "第 1 个标签，共 3 个']");
    }

    /**
     * 点击消息tab
     */
    public void clickMessageTab () {
        MobileElement mobileElement = driver.findElementByXPath("//android.widget.ImageView[@text='消息\n" +
                "第 2 个标签，共 3 个']");
        mobileElement.click();
    }

    /**
     * 点击我的tab
     */
    public void clickMineTab () {
        driver.findElementByXPath("//android.widget.ImageView[@text='我的\n" +
                "第 3 个标签，共 3 个']").click();
    }

    public void swipeHomePage () {
        //WebElement webElement = driver.findElementByXPath("//android.widget.ScrollView[1]");
        swipe(Direction.UP, null);
    }
}
