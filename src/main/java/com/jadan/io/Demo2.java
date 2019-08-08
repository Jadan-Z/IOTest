package com.jadan.io;

/**
 * @Author Jadan-Z
 * @Date 2019/8/7
 */
public class Demo2 {
    public static void main(String[] args) {
        Person person = new Person();
        person.say();
        // 装饰
        Amplifier am = new Amplifier(person);
        am.say();
    }
}

interface Say {
    void say();
}

class Person implements Say {
    // 属性
    private int voice = 10;

    @Override
    public void say() {
        System.out.println("人的声音为：" + this.getVoice());
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say {
    private Person p;

    Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("人的声音为：" + p.getVoice() * 100);
        System.out.println("噪音。。。");

    }
}