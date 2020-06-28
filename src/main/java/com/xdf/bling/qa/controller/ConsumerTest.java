package com.xdf.bling.qa.controller;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: ConsumerTest
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/17 10:21 上午
 */
public class ConsumerTest extends BaseController {

    @Test
    public void test1() throws InterruptedException {
//        driver.findElementByXPath("//android.view.View[@text='密码登录']").click();
//        driver.findElementByXPath("//android.widget.EditText[@text='请输入报名手机号']").click();
//        Actions action = new Actions(driver);
//        action.sendKeys("17621763856").perform();
//        driver.findElementByXPath("//android.widget.EditText[@text='请输入密码']").click();
//        action.sendKeys("123456a").perform();
//        driver.findElementByXPath("//android.view.View[@text='登录']").click();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        driver.findElementByXPath("//android.widget.ImageView[@text='我的\n" +
                "第 3 个标签，共 3 个']").click();
        driver.findElementByXPath("//android.widget.ImageView[2]").click();
        driver.findElementByXPath("//android.view.View[@text='头像']/android.widget.ImageView").click();
        driver.findElementByXPath("//android.widget.Button[@text='从手机相册选择']").click();
        driver.findElementByXPath("//*[@resource-id='com.android.documentsui:id/dir_list']/android.widget.LinearLayout[1]").click();
        driver.findElementByXPath("//*[@resource-id='com.blingabc.student:id/tv_control_finish']").click();
        String key = "头像更新成功";

        WebDriverWait wait = new WebDriverWait(driver, 5);
// 点击上一个按钮
        WebElement target = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'"+key+"')]")));
        System.out.println(target.getText());
        MobileElement birthday = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[1]");
        String sr = birthday.getText().split("出生日期")[1].trim();
        System.out.println(sr);
        birthday.click();
        Thread.sleep(3000);
        System.out.println(driver.getPageSource());
       driver.findElementByXPath("//android.widget.Button[@text='取消']").click();
        MobileElement englishName = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[2]");

        //System.out.println(shouye);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void swipeCrosswiseControl(MobileElement element){
        Point start=element.getLocation();
        int startX = start.x;
        int startY = start.y;
        Dimension wh=element.getSize();
        int Widthx=wh.getWidth();
        int Heighty=wh.getHeight();
        int endX = Widthx + startX;
        int endY = Heighty + startY;
        (new TouchAction(driver))
                .longPress(PointOption.point(startX,endY-Heighty/2))
                .moveTo(PointOption.point(startX,endY))
                .release()
                .perform();
    }

}
