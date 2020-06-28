package com.xdf.bling.qa.util;

import java.io.IOException;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: TypewritingUtil
 * @Description: 输入法工具
 * @Author: liuzhanhui
 * @Date: 2020/6/17 5:09 下午
 */
public class TypewritingUtil {

    private static String adbHome="/Users/liuzhanhui/lzh/soft/android-sdk-macosx/platform-tools/adb ";

    public static void chineseSendKeys (String chinese) {
        try {
            Runtime.getRuntime().exec(adbHome+ "shell ime set com.android.adbkeyboard/.AdbIME");
            Thread.sleep(2000);
            Runtime.getRuntime().exec(adbHome+ "shell am broadcast -a ADB_INPUT_TEXT --es msg "+chinese);
            Thread.sleep(3000);
            Runtime.getRuntime().exec(adbHome+ "shell ime set io.appium.settings/.UnicodeIME");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
