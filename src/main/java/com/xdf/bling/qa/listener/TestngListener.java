package com.xdf.bling.qa.listener;

import com.xdf.bling.qa.controller.BaseController;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: TestngListener
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/15 8:14 下午
 */
public class TestngListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        takePhoto(BaseController.getDriver());
    }

    @Attachment(value = "失败截图如下：",type = "image/png")
    public byte[]  takePhoto(AppiumDriver driver){
        byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }
}
