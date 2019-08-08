package com.jadan.io;

/**
 * @Author Jadan-Z
 * @Date 2019/8/7
 */
public class Demo3 {

    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink milk = new Milk(coffee);
        System.out.println(milk.cost());
        System.out.println(milk.info());
    }
}

// 抽象组件
interface Drink {
    double cost(); // 费用
    String info(); // 说明
}

// 具体组件
class Coffee implements Drink {
    private String name = "yxxx";
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

// 抽象装饰类
abstract class Descorate implements Drink {
    // 对抽象组件的引用
    private Drink drink;

    Descorate(Drink drink) {
        this.drink = drink;
    }
    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}
// 具体的装饰类
class Milk extends Descorate {

    Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() * 4;
    }

    @Override
    public String info() {
        return super.info() + "加了牛奶";
    }
}
