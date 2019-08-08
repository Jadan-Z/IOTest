package com.jadan.io;

import java.io.*;

/**
 * 1、封装拷贝
 * 2、封装释放资源
 * @Author Jadan-Z
 * @Date 2019/8/7
 */
public class FileUtils {
    public static void main(String[] args) {
        // 文件到文件
        try {
            InputStream is = new FileInputStream("D:/a.txt");
            OutputStream os = new FileOutputStream("D:/dest.txt");
            copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] datas = null;
        // 文件到字节数组
        try {
            InputStream is = new FileInputStream("C:/Users/Jadan-Z/Pictures/002.jpg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            copy(is, baos);

            datas = baos.toByteArray();
            System.out.println(datas.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("C:/Users/Jadan-Z/Pictures/11122.jpg");
            copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对接输入输出流
     * @param is
     * @param os
     */
    public static void copy(InputStream is, OutputStream os) {
        try {
            // 3、操作
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            close(is, os);
        }
    }

    /**
     * 释放资源
     * @param ios
     */
    public static void close(Closeable... ios) {
        for (Closeable io:ios) {
            try {
                if (io != null) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
