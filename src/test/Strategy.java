package test;

/**
 * 策略模式，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
 *
 * 在策略模式中，我们创建表示各种策略的对象和一个行为随着策
 * 略对象改变而改变的 context 对象。策略对象改变 context 对象的执行算法。
 *
 *  1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那
 *  么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
 *  2、一个系统需要动态地在几种算法中选择一种。
 *  3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就
 *  只好使用多重的条件选择语句来实现。
 */
interface call{
    void call();
}

class gua implements call{

    @Override
    public void call() {
        System.out.println("gua");
    }
}

class ga implements call{

    @Override
    public void call() {
        System.out.println("ga");
    }
}

class duck{
    private call caller;

    public void setCaller(call caller) {
        this.caller = caller;
    }

    public void call(){
        caller.call();
    }
}