package com.xdf.bling.qa.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @version v1.0
 * @ProjectName: autoTest
 * @ClassName: PathUtil
 * @Description: TODO(一句话描述该类的功能)
 * @Author: liuzhanhui
 * @Date: 2020/6/16 4:00 下午
 */
public class PathUtil {

    public static String returnFilePath(String filePath) throws IOException {
        //此处如果用File file = Resource.getFile(filePath)会报异常：找不到文件
        Resource resource = new ClassPathResource("classpath:testng/mine.xml");
        InputStream is = resource.getInputStream();
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8.name());
    }

    public static void main(String[] args) throws IOException {
        String path = returnFilePath("testng/mine.xml");
        System.out.println(path);
    }
}
