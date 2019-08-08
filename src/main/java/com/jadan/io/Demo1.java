package com.jadan.io;

import java.io.*;

/**
 * @Author Jadan-Z
 * @Date 2019/8/7
 */
public class Demo1 {
    public static void main(String[] args) {
        test();
    }

    // 字节文件输入流
    public static void test01() {
        // 1、创建源
        File src = new File("D:/a.txt");
        // 2、选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            // 3、操作（读取）
            int temp;
            while ((temp = is.read()) != -1) {
                System.out.println((char)temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 字节文件输出流
    public static void test02() {
        // 1、创建源
        File des = new File("D:/a.txt");
        // 2、选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(des);
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

    // 文件拷贝: 加入缓冲流
    public static void test03() {
        // 1、创建源
        File src = new File("D:/迅雷下载/log4j-1.2.17.zip");
        File des = new File("D:/11.zip");

        // 2、选择留
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new BufferedInputStream(new FileInputStream(src));
            os = new BufferedOutputStream(new FileOutputStream(des));

            // 3、操作
            // 3.1 读取
            byte[] bytes = new byte[3];
            int len = -1;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 文件字符输入流
    public static void test04() {
        // 1、创建源
        File src = new File("D:/a.txt");
        // 2、选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            // 3、操作
            char[] flush = new char[1024];
            int len = -1;
            while ((len = reader.read(flush)) != -1) {
                String msg = new String(flush, 0, len);
                System.out.println(msg);
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

    // 文件字符输出流
    public static void test05() {
        // 1、创建源
        File des = new File("D:/des.txt");
        // 2、选择流
        Writer writer = null;
        try {
            writer = new FileWriter(des, false);
            // 3、写出操作
//            String msg = "Io is so easy.";
//            char[] flush = msg.toCharArray();
//            writer.write(flush);
            writer.append("xxx").append("yyy");
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

    // 字节数组输入流(无需释放资源)
    public static void test06() {
        // 1、创建源
        byte[] src = "talk is cheap, show me the code.".getBytes();
        // 2、选择流
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(src);
            // 3、操作(分段读取)
            byte[] flush = new byte[5]; // 缓冲容器
            int len = -1; // 接收长度
            while ((len = is.read(flush)) != -1) {
                // 字节数组 --> 字符串（解码）
                String msg = new String(flush, 0, len);
                System.out.println(msg);
            }
        }catch (IOException e ) {
            e.printStackTrace();
        }
    }

    // 字节数组输出流(无需释放资源)
    public static void test07() {
        // 1、创建源：内部维护
        byte[] dest = null;
        // 2、选择流：使用新方法，不关联源
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            // 3、操作写出
            String msg = "show me the code.11";
            byte[] datas = msg.getBytes(); // 字符串 --> 字节数组(编码)
            baos.write(datas, 0, datas.length);
            baos.flush();

            // 获取数据 toByteArray
            dest = baos.toByteArray();
            System.out.println(new String(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1、 图片读取到字节数组中
     * 2、 字节数组写出到文件
     */
    public static void test08() {
        // 1、创建源
        File src = new File("C:/Users/Jadan-Z/Pictures/002.jpg");
        File dest = new File("C:/Users/Jadan-Z/Pictures/0201.jpg");
        // 2、选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            // 3、读取操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 图片读取到字节数组
     * 1）图片到程序 FileInputStream
     * 2）程序到字节数组 ByteArrayOutputStream
     */
    public static byte[] fileToByteArray(String filePath) {
        // 1、创建源与目的地
        File src = new File(filePath);
//        byte[] dest = null;
        // 2、选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            // 3、操作（读取）
            byte[] flush = new byte[1024 * 10]; // 缓冲容器
            int len = -1;  // 接收长度
            while ((len = is.read(flush)) != -1) {
                baos.write(flush, 0, len);// 写出到字节数组中
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 2、字节数组写出到图片
     * 1）字节数组到程序 ByteArrayInputStream
     * 2）程序到文件 FileOutputStream
     * @param src
     * @param filePath
     */
    public static void byteArrayToFile(byte[] src, String filePath) {
        // 1、创建源
        File dest = new File(filePath);
        // 2、选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            // 3、分段读取操作
            byte[] flush = new byte[1024]; // 缓冲容器
            int len = -1; // 接收长度
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len); // 写出到文件
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、释放资源
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 字节数组输出流
    public static void test() {
        // 图片转字节数组
//        byte[] datas = fileToByteArray("C:/Users/Jadan-Z/Pictures/002.jpg");
//        System.out.println(datas.length);
//        byteArrayToFile(datas, "C:/Users/Jadan-Z/Pictures/0021.jpg");
        Long t1 = System.currentTimeMillis();
        test03();

        Long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

}
