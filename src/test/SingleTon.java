package test;

/**
 * 采取一定方法保证在整个软件系统中，对某个类只有一个对象实例，并
 * 且该类只提供一个获得其实例的方法。
 *
 * 例子：Hibernate SessionFactory JVM RunTime
 *
 * 使用场景：需要频繁进行创建和相会，创建对象耗时过多或者资源过多
 * 经常使用到的对象
 *
 */

/**
 * 饿汉式（静态变量）
 * 优点：在类加载时候就完成实例化，笔迷拿了线程同步的问题
 * 缺点：没有达到懒加载效果，如果一直没有用到，则会造成浪费
 * 可用、但可能造成内存浪费
 */
class Singleton {
    private final static Singleton instance = new Singleton();
    private Singleton(){

    }

    public Singleton getInstance(){
        return instance;
    }
}

/**
 * 饿汉式（静态代码块）
 */
class Singleton2{
   private static Singleton2 instance;
   static{
       instance = new Singleton2();
   }
   private Singleton2(){

   }


    public static Singleton2 getInstance() {
        return instance;
    }
}

/**
 * 懒汉式（饱汉式） 线程不安全
 * 优点：达到懒加载
 * 缺点：线程不安全，不要使用这种
 */
class Singleton3{
    private static Singleton3 instance;

    private Singleton3(){

    }

    public static Singleton3 getInstance() {
        if(instance==null){
            instance = new Singleton3();
        }
        return instance;
    }
}

/**
 * 懒汉式
 * 解决了线程安全问题
 * 但效率太低，不推荐
 */
class Singleton4{
    private static Singleton4 instance;

    private Singleton4(){

    }

    public static synchronized Singleton4 getInstance() {
        if(instance==null){
            instance = new Singleton4();
        }
        return instance;
    }
}

/**
 * 懒汉式 双重检查
 * 推荐
 */
class Singleton5{
    private static volatile Singleton5 instance;

    private Singleton5(){

    }

    public static Singleton5 getInstance() {
        if(instance==null){
            synchronized (Singleton5.class){
                if(instance==null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

/**
 * 懒汉式
 * 静态内部类
 * 推荐
 * 静态内部类不在外部类初始化时初始化
 */
class Singleton6{
    private static class Singleton6Instance {
        private static final Singleton6 instance=new Singleton6();
    }

    private Singleton6(){

    }

    public static Singleton6 getInstance() {
        return Singleton6Instance.instance;
    }
}

/**
 * 枚举
 * 强推荐
 */
class Singleton7{

    private Singleton7(){
    }

    enum Singleton7Enum{
        INSTANCE;
        private Singleton7 instance;
        private Singleton7Enum(){
            instance=new Singleton7();
        }
        private Singleton7 getInstance(){
            return instance;
        }
    }
    public static Singleton7 getInstance() {
        return Singleton7Enum.INSTANCE.getInstance();
    }
}



