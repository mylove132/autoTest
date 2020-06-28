package com.xdf.bling.qa.page.mine;

import com.xdf.bling.qa.page.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: HomePage
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/16 4:06 下午
 */
public class MinePage extends BasePage {

    public MinePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * 点击我的页面头像
     */
    public void clickMinePageHeaderImage () {
        driver.findElementByXPath("//android.widget.ImageView[2]").click();
    }

    /**
     * 判断我的页面头像显示
     * @return
     */
    public boolean isShowMinePageHeaderImage () {
        MobileElement minePageHeaderImg = driver.findElementByXPath("//android.widget.ImageView[2]");
        return isPresent(minePageHeaderImg);
    }

    /**
     * 判断我的页面用户名显示
     * @return
     */
    public boolean isShowMinePageUserName () {
        MobileElement minePageHeaderUserName = driver.findElementByXPath("//android.widget.ImageView[2]/following-sibling::android.view.View[1]");
        return isPresent(minePageHeaderUserName);
    }


    /**
     * 判断宝贝页面头像显示
     * @return
     */
    public boolean isShowBabyPageHeaderImage () {
        MobileElement babyPageHeaderImage = driver.findElementByXPath("//android.view.View[@text='头像']/android.widget.ImageView");
        return isPresent(babyPageHeaderImage);
    }

    /**
     * 点击baby页面头像
     */
    public void clickBabyPageHeaderImage () {
        MobileElement babyPageHeaderImage = driver.findElementByXPath("//android.view.View[@text='头像']/android.widget.ImageView");
        babyPageHeaderImage.click();
    }

    /**
     * 点击从手机相册选
     */
    public void clickChooseHeaderFormMobileAlbum () {
        driver.findElementByXPath("//android.widget.Button[@text='从手机相册选择']").click();
        driver.findElementByXPath("//*[@resource-id='com.android.documentsui:id/dir_list']/android.widget.LinearLayout[1]").click();
        driver.findElementByXPath("//*[@resource-id='com.blingabc.student:id/tv_control_finish']").click();
    }

    /**
     * 判断更换头像成功toast出现
     * @return
     */
    public boolean changeHeaderImageSuccessToast () {
        return isShowToast("头像更新成功");
    }


    /**
     * 判断宝贝页面生日显示
     * @return
     */
    public boolean isShowBabyPageBirthday () {
        MobileElement babyPageBirthday = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[1]");
        return isPresent(babyPageBirthday);
    }

    /**
     * 判断宝贝页面英文名称显示
     * @return
     */
    public boolean isShowBabyPageEnglishName () {
        MobileElement babyPageEnglishName = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[2]");
        return isPresent(babyPageEnglishName);
    }

    /**
     * 点击英文名称
     */
    public void clickBabyPageEnglishName () {
        MobileElement babyPageEnglishName = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[2]");
        babyPageEnglishName.click();
    }

    /**
     * 获取英文名称
     */
    public String getBabyPageEnglishName () {
        MobileElement babyPageEnglishName = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[2]");
        return babyPageEnglishName.getText().split("英文名字")[1].trim();
    }


    /**
     * 判断宝贝页面中文名称显示
     * @return
     */
    public boolean isShowBabyPageChineseName () {
        MobileElement babyPageChineseName = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[3]");
        return isPresent(babyPageChineseName);
    }

    /**
     * 点击中文名称
     */
    public void clickBabyPageChineseName () {
        MobileElement babyPageChineseName = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[3]");
        babyPageChineseName.click();
    }

    /**
     * 点击输入框保存按钮
     */
    public void clickBabyPageTextInputSaveButton () {
        MobileElement babyPageTextEditorSaveButton = driver.findElementByXPath("//android.widget.Button[@text='保存']");
        babyPageTextEditorSaveButton.click();
    }

    /**
     * 获取中文名称
     */
    public String getBabyPageChineseName () {
        MobileElement babyPageChineseName = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[3]");
        return babyPageChineseName.getText().split("中文名字")[1].trim();
    }

    /**
     * 修改名称输入框
     */
    public void setBabyPageTextInput (String value, boolean isChinese) {
        MobileElement babyPageTextEditorInput = driver.findElementByXPath("//android.widget.EditText[1]");
        actionSendkeys(babyPageTextEditorInput, value, true, isChinese);
    }

    /**
     * 判断宝贝页面性别显示
     * @return
     */
    public boolean isShowBabyPageGender () {
        MobileElement babyPageGender = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[4]");
        return isPresent(babyPageGender);
    }

    /**
     * 获取展示的性别
     * @return
     */
    public String getShowBabyPageGender () {
        MobileElement babyPageGender = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[4]");
        return babyPageGender.getText().split("选择孩子的性别")[1].trim();
    }

    /**
     * 点击性别
     */
    public void clickBabyPageGender () {
        MobileElement babyPageGender = driver.findElementByXPath("//android.view.View[@text='头像']/following-sibling::android.widget.ImageView[4]");
        babyPageGender.click();
    }

    /**
     * 点击选则男
     */
    public void clickGenderOfMale () {
        driver.findElementByXPath("//android.widget.Button[@text='男']").click();
    }

    /**
     * 点击选择女
     */
    public void clickGenderOfFemale () {
        driver.findElementByXPath("//android.widget.Button[@text='女']").click();
    }

    /**
     * 更新性别toast
     * @return
     */
    public boolean isShowBabyGenderupdateSuccessToast () {
        return isShowToast("宝贝信息更新成功");
    }

    /**
     * 点击我的信息tab
     */
    public void clickMineInfoTab () {
        driver.findElementByXPath("//android.widget.Button[1]/following-sibling::android.view.View[3]").click();
    }

    /**
     * 是否存在用户姓名
     * @return
     */
    public boolean isExistUserName () {
        MobileElement mobileElement =  driver.findElementByXPath("//android.widget.ImageView[1]");
        return mobileElement.getText().contains("用户姓名");
    }

    /**
     * 获取用户姓名
     * @return
     */
    public String getUserName () {
        MobileElement mobileElement =  driver.findElementByXPath("//android.widget.ImageView[1]");
        return mobileElement.getText().split("用户姓名")[1].trim();
    }

    /**
     * 点击用户姓名
     * @return
     */
    public void clickUserName () {
        MobileElement mobileElement =  driver.findElementByXPath("//android.widget.ImageView[1]");
        mobileElement.click();
    }

    /**
     * 判断更新成功的toast
     * @return
     */
    public boolean isShowUpdateSuccessToast () {
        return isShowToast("更新成功~");
    }

    /**
     * 获取手机号
     * @return
     */
    public String getPhone () {
        MobileElement mobileElement =  driver.findElementByXPath("//android.widget.ImageView[1]/following-sibling::android.view.View[1]");
        return mobileElement.getText().split("手机号码")[1].trim();
    }

    /**
     * 获取所在地
     * @return
     */
    public String getLocation () {
        MobileElement mobileElement =  driver.findElementByXPath("//android.widget.ImageView[2]");
        return mobileElement.getText().split("所在地区")[1].trim();
    }

    /**
     * 点击所在地
     */
    public void clickLocation () {
        MobileElement mobileElement =  driver.findElementByXPath("//android.widget.ImageView[2]");
        mobileElement.click();
    }

    public String getCityName () {
        MobileElement mobileElement =  driver.findElementByXPath("//android.widget.Button[@text='确定']/following-sibling::android.widget.SeekBar[1]");
        return mobileElement.getText().split("所在地区")[1].trim();
    }

    public void swipeCity () {
        MobileElement mobileElement =  driver.findElementByXPath("//android.widget.Button[@text='确定']/following-sibling::android.widget.SeekBar[1]");
        System.out.println(mobileElement.getText());
        swipe(Direction.UP, mobileElement);
    }
}
