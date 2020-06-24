package test;

/**
 * 将某个类的接口转换为客户端期望的另一个接口表示
 * ，主要目的是兼容，让原本因接口不匹配不能一起工作
 * 的两个类可以协同工作，别名为包装器wrapper
 *  主要非为三类，类适配器模式，对象适配器模式，
 *  接口适配器模式
 */


/**
 * 类适配器
 * 通过继承被适配的src类，实现目标接口
 * 单继承，所以要求dis必须是接口，
 * src类方法会被adpter暴漏，增加使用成本
 *
 */
class Adaptee {
    public void adapteeRequest() {
        System.out.println("被适配者的方法");
    }
}

interface Target {
    void request();
}


class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.adapteeRequest();
    }
}

/**
 * 对象适配器，不在继承src，而是持有src类的实例，实现接口
 */
class Adapter2 implements Target{
    Adaptee adaptee=new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}

/**
 * 接口适配器模式
 * 不想实现接口中某些方法，可以用抽象类默认实现，子类在继承
 * 该抽象类
 */
class Adapter3{

}