package com.jadan.io;

import java.io.*;
import java.net.URL;

/**
 * 转换流：InputStreamReader、OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本）
 * 2、指定字符集
 *
 * @Author Jadan-Z
 * @Date 2019/8/7
 */
public class ConvertTest {
    public static void main(String[] args) {
        test2();

    }

    public static void test1() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {
            // 循环获取键盘的输入（exit退出），输出此内容
            String msg = "";
            while (!"exit".equals(msg)) {
                msg = reader.readLine(); // 循环读取
                writer.write(msg); // 循环写出
                writer.newLine();
                writer.flush(); // 强制刷新
            }
        } catch (IOException e) {
            System.out.println("操作异常");
        }
    }

    // 操作网络流，下载百度的源代码
    public static void test21() {
        try(InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8");) {
            // 3、读取操作
            int len = -1;
            while ((len = is.read()) != -1) {
                System.out.print((char)len); // 字节数不够出现乱码
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 操作网络流，下载百度的源代码
    public static void test2() {
        try(BufferedReader is =
                    new BufferedReader(
                            new InputStreamReader(
                                    new URL("http://www.baidu.com").openStream(), "UTF-8"));
            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream("D:/baidu.html"), "UTF-8"));) {
            // 3、读取操作
            String msg = null;
            while ((msg = is.readLine()) != null) {
                writer.write(msg); // 字符集不同统一
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
