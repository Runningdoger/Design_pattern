package test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
 * 比如，当一个对象被修改时，则会自动通知它的依赖对象。观察者模式
 * 属于行为型模式。
 * 一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，
 * 保证高度的协作。
 *
 * 使用场景：
 * 一个抽象模型有两个方面，其中一个方面依赖于另一个方面。将这些方
 * 面封装在独立的对象中使它们可以各自独立地改变和复用。
 *
 * 一个对象的改变将导致其他一个或多个对象也发生改变，而不知道具体
 * 有多少对象将发生改变，可以降低对象之间的耦合度。
 *
 * 一个对象必须通知其他对象，而并不知道这些对象是谁。
 * 需要在系统中创建一个触发链，A对象的行为将影响B对象，B对象的行
 * 为将影响C对象……，可以使用观察者模式创建一种链式触发机制。
 *
 * 优点： 1、观察者和被观察者是抽象耦合的。 2、建立一套触发机制。
 *
 * 缺点：
 * 1、如果一个被观察者对象有很多的直接和间接的观察者的话，
 * 将所有的观察者都通知到会花费很多时间。
 * 2、如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它
 * 们之间进行循环调用，
 * 可能导致系统崩溃。
 *
 * 3、观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么
 * 发生变化的，而仅仅只是知道观察目标发生了变化。
 */
class Subject {

    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}

class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}

class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}

class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}