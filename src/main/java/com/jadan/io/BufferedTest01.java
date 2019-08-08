package com.jadan.io;

import java.io.*;

/**
 * @Author Jadan-Z
 * @Date 2019/8/7
 */
public class BufferedTest01 {
    public static void main(String[] args) {
//        test02();
//        test03();
        copyTxt("D:/a.txt", "D:dest.txt");
    }

    public static void test01() {
        // 1、创建源
        File src = new File("D:/a.txt");
        // 2、选择流
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            // 3、分段读取操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String msg = new String(flush, 0, len);
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try{
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test1() {
        // 1、创建源
        File des = new File("D:/a.txt");
        // 2、选择流
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(des));
            // 3、写入操作
            String msg = "talk is cheap.";
            // 字符串转字节数组（编码）
            byte[] datas = msg.getBytes();
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test02() {
        // 1、创建源
        File src = new File("D:/a.txt");
        // 2、选择流
        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new FileReader(src));
            // 3、操作
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test03() {
        // 1、创建源
        File des = new File("D:/des.txt");
        // 2、选择流
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(des, false));
            // 3、写出操作
            writer.append("xxx");
            writer.newLine();
            writer.append("yyy");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try {
                if (null != writer) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // 仅限纯文本拷贝
    public static void copyTxt(String srcPath, String destPath) {
        // 1、创建源
        File src = new File(srcPath);
        File dest = new File(destPath);
        // 2、选择流
        try(BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {
            // 3、操作(逐行读取)
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line); // 逐行写出
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
