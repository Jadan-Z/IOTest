package com.jadan.io;

import java.io.*;

/**
 * 对象流：
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * 3、不是所有的对象都可以序列化 Serializable
 * @Author: Jadan-Z
 * @Date: 2019/8/7
 */
public class ObjectTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 写出: 序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        // 操作数据类型 + 数据
        dos.writeUTF("编码辛酸泪");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.writeObject(123L);
        dos.flush();
        byte[] datas = baos.toByteArray();

        // 读取：反序列化
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        // 顺序与写出的一致
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char c = dis.readChar();
        Object o = dis.readObject();
        System.out.println(o);
    }
}
















