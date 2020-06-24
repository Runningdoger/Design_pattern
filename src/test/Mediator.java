package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者模式定义一个中介对象来封装一系列对象之间的交互，
 * 使原有对象之间的耦合松散，且可以独立地改变它们之间的
 * 交互。中介者模式又叫调停模式，它是迪米特法则的典型应用。
 * 朋友与朋友之间是网状关系，但中间可以有一个中介，进行处理
 * 就像打电话，一个中介负责解给你要打的对象
 */
class test
{
    public static void main(String[] args)
    {
        Mediator md=new ConcreteMediator();
        Colleague c1,c2;
        c1=new ConcreteColleague1();
        c2=new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send(c2);
        System.out.println("-------------");
        c2.send(c1);
    }
}
//抽象中介者
abstract class Mediator
{
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl); //转发
}
//具体中介者
class ConcreteMediator extends Mediator
{
    private List<Colleague> colleagues=new ArrayList<Colleague>();
    @Override
    public void register(Colleague colleague)
    {
        if(!colleagues.contains(colleague))
        {
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }
    @Override
    public void relay(Colleague cl)
    {
        for(Colleague ob:colleagues)
        {
            if(!ob.equals(cl))
            {
                ((Colleague)ob).receive();
            }
        }
    }
}
//抽象同事类
abstract class Colleague
{
    protected Mediator mediator;
    public void setMedium(Mediator mediator)
    {
        this.mediator=mediator;
    }
    public abstract void receive();
    public abstract void send(Colleague dis);
}
//具体同事类
class ConcreteColleague1 extends Colleague
{
    @Override
    public void receive()
    {
        System.out.println("具体同事类1收到请求。");
    }
    @Override
    public void send(Colleague dis)
    {
        System.out.println("具体同事类1发出请求。");
        mediator.relay(dis); //请中介者转发
    }
}
//具体同事类
class ConcreteColleague2 extends Colleague
{
    @Override
    public void receive()
    {
        System.out.println("具体同事类2收到请求。");
    }
    @Override
    public void send(Colleague dis)
    {
        System.out.println("具体同事类2发出请求。");
        mediator.relay(dis); //请中介者转发
    }
}