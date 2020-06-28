package com.xdf.bling.qa.page;

import com.xdf.bling.qa.util.TypewritingUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: BasePage
 * @Description: 页面基本操作
 * @Author: liuzhanhui
 * @Date: 2020/6/15 7:07 下午
 */
public class BasePage {

    protected AndroidDriver<MobileElement> driver;

    public BasePage (AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    /**
     * 模拟输入
     * @param element
     * @param keys
     */
    protected void actionSendkeys(MobileElement element, String keys, boolean isClear, boolean isChinese) {
        element.click();
        if (isClear) {
            String text = element.getText();
            for (int i = 0; i < text.length() - 1; i++) {
                driver.pressKey(new KeyEvent(AndroidKey.DEL));
            }
        }
        if (isChinese) {
            TypewritingUtil.chineseSendKeys(keys);
            return;
        }
        Actions action = new Actions(driver);
        action.sendKeys(keys).perform();
    }

    /**
     * 判断元素出现
     * @param element
     * @return
     */
    protected boolean isPresent (MobileElement element) {
        try {
            MobileElement ele = element;
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * 判断toast出现
     * @param toast
     * @return
     */
    protected boolean isShowToast (String toast) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement target = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'"+toast+"')]")));
            return true;
        }catch (Exception e){
            return false;
        }

    }

    /**
     * 滑动
     * @param direction
     * @param element
     */
    protected void swipe (Direction direction, MobileElement element) {
        TouchAction touchAction = new TouchAction(driver);
        if (element == null) {
            int width=driver.manage().window().getSize().width;
            int height=driver.manage().window().getSize().height;
            int y1 = height*3/4;
            int y2 = height /4;
            int x1 = width*3/4;
            int x2 = width /4;
            switch (direction) {
                case UP:
                    touchAction.longPress(PointOption.point(width/2, y1)).waitAction(WaitOptions.waitOptions( Duration.ofMillis(200))).moveTo(PointOption.point(width/2,y2)).release().perform();
                    break;
                case DOWN:
                    touchAction.longPress(PointOption.point(width/2, y2)).waitAction(WaitOptions.waitOptions( Duration.ofMillis(200))).moveTo(PointOption.point(width/2,y1)).release().perform();
                    break;
                case LEFT:
                    touchAction.longPress(PointOption.point(x1, height/2)).waitAction(WaitOptions.waitOptions( Duration.ofMillis(200))).moveTo(PointOption.point(x2, height/2)).release().perform();
                    break;
                case RIGHT:
                    touchAction.longPress(PointOption.point(x2, height/2)).waitAction(WaitOptions.waitOptions( Duration.ofMillis(200))).moveTo(PointOption.point(x1, height/2)).release().perform();
                    break;
            }
            return;
        }

        int pointX = element.getSize().getWidth();
        int pointY = element.getSize().getHeight();
        System.out.println("控件X；"+pointX+"控件Y："+pointY);
        switch (direction) {
            case LEFT:
                touchAction.longPress(PointOption.point(pointX*3/4, pointY/2)).waitAction(WaitOptions.waitOptions( Duration.ofMillis(200))).moveTo(PointOption.point(pointX/4, pointY/2)).release().perform();
                break;
            case RIGHT:
                touchAction.longPress(PointOption.point(pointX/4, pointY/2)).waitAction(WaitOptions.waitOptions( Duration.ofMillis(200))).moveTo(PointOption.point(pointX*3/4, pointY/2)).release().perform();
                break;
            case DOWN:
                touchAction.longPress(PointOption.point(pointX/2, pointY/4)).waitAction(WaitOptions.waitOptions( Duration.ofMillis(200))).moveTo(PointOption.point(pointX/2, pointY*3/4)).release().perform();
                break;
            case UP:
                touchAction.longPress(PointOption.point(pointX/2, pointY*3/4)).waitAction(WaitOptions.waitOptions( Duration.ofMillis(500))).moveTo(PointOption.point(pointX/2, pointY/4)).release().perform();
                break;
        }
    }

    protected enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
