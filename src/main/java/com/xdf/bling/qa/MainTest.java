package com.xdf.bling.qa;

import org.apache.commons.cli.*;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: MainTest
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/16 1:46 下午
 */
public class MainTest {

    public static void main(String[] args) throws ParseException {
        TestNG testNG = new TestNG();
        List<String> xmlPaths = new ArrayList<String>();
        Option option = new Option("f", "file", true, "testng.xml文件");
        Options options = new Options();
        options.addOption(option);

        PosixParser parser = new PosixParser();
        CommandLine commandLine = parser.parse(options, args);
        //是否输入了参数 -f
        boolean f = commandLine.hasOption("f");
        System.out.println("是否输入了-f参数："+f);
        if (!f) {
            xmlPaths.add(System.getProperty("user.dir")+"/testng.xml");
            testNG.setTestSuites(xmlPaths);
            testNG.run();
        } else {
            String tPath = commandLine.getOptionValue("f");
            List<String> tPaths = new ArrayList<String>();
            if (tPath.contains(",")) {
                tPaths.addAll(java.util.Arrays.asList(tPath.split(",")));
            } else {
                tPaths.add(tPath);
            }
            for (String p : tPaths) {
                if (p.startsWith("/")) {
                    xmlPaths.add(p);
                } else {
                    xmlPaths.add(System.getProperty("user.dir")+"/src/main/resources/testng/"+p);
                }

            }
            testNG.setTestSuites(xmlPaths);
            testNG.run();
        }



    }
}
