package com.jadan.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Jadan-Z
 * @Date: 2019/8/7
 */
public class CommonsIOTest {

    public static void main(String[] args) throws IOException {
        // 文件大小
        long len = FileUtils.sizeOf(new File("D:/a.txt"));
        System.out.println(len);
        // 目录大小
        len = FileUtils.sizeOf(new File("D:/apollo"));
        System.out.println(len);

        String msg = FileUtils.readFileToString(new File("D:/a.txt"), "UTF-8");
        System.out.println(msg);
        byte[] datas = FileUtils.readFileToByteArray(new File("D:/a.txt"));
        System.out.println(datas.length);
        // 逐行读取
        List<String> msgs = FileUtils.readLines(new File("D:/a.txt"), "UTF-8");
        LineIterator lineIterator = FileUtils.lineIterator(new File("D:/a.txt"), "UTF-8");
    }

}
