package com.xdf.bling.qa.service.home;

import com.xdf.bling.qa.page.home.HomePage;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: LoginService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/15 7:13 下午
 */
public class HomeService {

    private final HomePage homePage;

    public HomeService(HomePage homePage) {
        this.homePage = homePage;
    }

    /**
     * 进入我的页面
     */
    public void enterMinePageService () {
        homePage.clickMineTab();
       }


    public void swipeHomePageService () {
        homePage.swipeHomePage();
    }
}
