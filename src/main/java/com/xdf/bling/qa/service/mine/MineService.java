package com.xdf.bling.qa.service.mine;

import com.xdf.bling.qa.page.mine.MinePage;
import org.testng.Assert;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: LoginService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/15 7:13 下午
 */
public class MineService {

    private final MinePage minePage;

    public MineService( MinePage minePage) {
        this.minePage = minePage;
    }

    /**
     * 验证进入登录页面
     */
    public void verifyEnterMinePageService () {
        Assert.assertTrue(minePage.isShowMinePageHeaderImage(), "进入我的页面头像没显示");
        Assert.assertTrue(minePage.isShowMinePageUserName(), "进入我的页面用户名没显示");
    }

    /**
     * 验证进入baby页面
     */
    public void verifyEnterBabyPageService () {
        minePage.clickMinePageHeaderImage();
        Assert.assertTrue(minePage.isShowBabyPageBirthday(), "进入宝贝页面生日没显示");
        Assert.assertTrue(minePage.isShowBabyPageHeaderImage(), "进入宝贝页面头像没显示");
        Assert.assertTrue(minePage.isShowBabyPageEnglishName(), "进入宝贝页面英文名称没显示");
        Assert.assertTrue(minePage.isShowBabyPageChineseName(), "进入宝贝页面中文名称没显示");
        Assert.assertTrue(minePage.isShowBabyPageGender(), "进入宝贝页面性别没显示");
    }

    public void verifyChangeAvatar() {
        minePage.clickBabyPageHeaderImage();
        minePage.clickChooseHeaderFormMobileAlbum();
        Assert.assertTrue(minePage.changeHeaderImageSuccessToast(), "更新头像成功的toast没出现");
    }

    /**
     * 修改英文名称
     * @param englishName
     */
    public void changeBabyEnglishNameService (String englishName) {
        String oldName = minePage.getBabyPageEnglishName();
        minePage.clickBabyPageEnglishName();
        minePage.setBabyPageTextInput(englishName, false);
        minePage.clickBabyPageTextInputSaveButton();
        Assert.assertTrue(minePage.isShowBabyGenderupdateSuccessToast(), "更新性别的toast没提示");
        String newName = minePage.getBabyPageEnglishName();
        Assert.assertEquals(englishName.trim(), newName.trim(), "需要修改的名称：" + englishName + "，修改后显示的名称：" + newName + "不一致");
        minePage.clickBabyPageEnglishName();
        minePage.setBabyPageTextInput(oldName, false);
        minePage.clickBabyPageTextInputSaveButton();
    }

    /**
     * 修改中文名称
     * @param chineseName
     */
    public void changeBabyChineseNameService (String chineseName) {
        String oldName = minePage.getBabyPageChineseName();
        minePage.clickBabyPageChineseName();
        minePage.setBabyPageTextInput(chineseName, true);
        minePage.clickBabyPageTextInputSaveButton();
        Assert.assertTrue(minePage.isShowBabyGenderupdateSuccessToast(), "更新性别的toast没提示");
        String newName = minePage.getBabyPageChineseName();
        Assert.assertEquals(chineseName.trim(), newName.trim(), "需要修改的名称：" + chineseName + "，修改后显示的名称：" + newName + "不一致");
        minePage.clickBabyPageChineseName();
        minePage.setBabyPageTextInput(oldName, true);
        minePage.clickBabyPageTextInputSaveButton();
    }

    /**
     * 修改baby性别
     */
    public void changeBabyGenderService () {
        String babyShowGender = minePage.getShowBabyPageGender();
        minePage.clickBabyPageGender();
        if ("男".equals(babyShowGender)) {
            minePage.clickGenderOfFemale();
            String newGender = minePage.getShowBabyPageGender();
            Assert.assertEquals(newGender, "女", "修改性别为女失败'");
        } else {
            minePage.clickGenderOfMale();
            String newGender = minePage.getShowBabyPageGender();
            Assert.assertEquals(newGender, "男", "修改性别为男失败'");
        }
        Assert.assertTrue(minePage.isShowBabyGenderupdateSuccessToast(), "更新性别的toast没提示");

    }

    /**
     * 验证进入我的信息页面
     */
    public void verityEnterMineInfoPage() {
        minePage.clickMineInfoTab();
        Assert.assertTrue(minePage.isExistUserName(), "进入我的信息页没有显示用户姓名");
    }

    /**
     * 修改我的信息用户名
     * @param userName
     */
    public void changeUserName (String userName) {
        String oldName = minePage.getUserName();
        minePage.clickUserName();
        minePage.setBabyPageTextInput(userName, true);
        minePage.clickBabyPageTextInputSaveButton();
        Assert.assertTrue(minePage.isShowUpdateSuccessToast(), "更新成功toast没提示");
        String newName = minePage.getUserName();
        Assert.assertEquals(userName, newName.trim(), "需要修改的名称：" + userName + "，修改后显示的名称：" + newName + "不一致");

        // 恢复旧name
        minePage.clickUserName();
        minePage.setBabyPageTextInput(oldName, true);
        minePage.clickBabyPageTextInputSaveButton();
    }


    public void changeLocation () {
        minePage.clickLocation();
        for (int i = -0;i<5;i++) {
            minePage.swipeCity();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
