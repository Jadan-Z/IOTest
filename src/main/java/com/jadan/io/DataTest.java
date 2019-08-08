package com.jadan.io;

import java.io.*;

/**
 * 数据流：
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * @Author: Jadan-Z
 * @Date: 2019/8/7
 */
public class DataTest {

    public static void main(String[] args) throws IOException {
        // 写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        // 操作数据类型 + 数据
        dos.writeUTF("编码辛酸泪");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();

        // 读取
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        // 顺序与写出的一致
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char c = dis.readChar();
        System.out.println(flag);
    }
}
















