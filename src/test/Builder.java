package test;

/**
 * 是将一个复杂的对象的构建与它的表示分离，使
 * 得同样的构建过程可以创建不同的表示。创建者
 * 模式隐藏了复杂对象的创建过程，它把复杂对象
 * 的创建过程加以抽象，通过子类继承或者重载的
 * 方式，动态的创建具有复合属性的对象。
 *
 * 四个角色：
 * product: 一个具体的产品
 * buider: 创建一个product的对象的各个部件指定的接口或者
 * 抽象类
 * concretBuider 具体建造者：实现接口，构建和装配各个部件
 * direct：构建一个使用buider接口的对象， 它主要用于创建一个
 * 复杂的对象，隔离了客户与对象的生产对象，负责控制产品对象的
 * 生产过程
 */

/**
 * 标准建造者模式
 * builder抽象类
 */
public abstract class Builder {
    abstract void buildFrame();
    abstract void buildSeat();
    abstract void buildTire();
    abstract Bike createBike();
}

class MobikeBuilder extends Builder{
    private Bike mBike = new Bike();
    @Override
    void buildFrame() {
        mBike.setFrame(1);
    }
    @Override
    void buildSeat() {
        mBike.setSeat(1);
    }
    @Override
    void buildTire() {
        mBike.setTire(1);
    }
    @Override
    Bike createBike() {
        return mBike;
    }
}

class OfoBuilder extends Builder{
    private Bike mBike = new Bike();
    @Override
    void buildFrame() {
        mBike.setFrame(2);
    }
    @Override
    void buildSeat() {
        mBike.setSeat(2);
    }
    @Override
    void buildTire() {
        mBike.setTire(2);
    }
    @Override
    Bike createBike() {
        return mBike;
    }
}
class Director {
    private Builder mBuilder = null;
    public Director(Builder builder) {
        mBuilder = builder;
    }
    public Bike construct() {
        mBuilder.buildFrame();
        mBuilder.buildSeat();
        mBuilder.buildTire();
        return mBuilder.createBike();
    }
}

class Bike {

    private int frame;
    private int seat;
    private int tire;

    public int getFrame() {
        return frame;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getTire() {
        return tire;
    }

    public void setTire(int tire) {
        this.tire = tire;
    }
}

class Click {
    public static void main(String[] args) {
        showBike(new OfoBuilder());
        showBike(new MobikeBuilder());
    }
    private static void showBike(Builder builder) {
        Director director = new Director(builder);
        Bike bike = director.construct();
    }
}


/**
 * 当一个类构造器需要传入很多参数时，如
 * 果创建这个类的实例，代码可读性会非常差，而
 * 且很容易引入错误，此时就可以利用 builder模
 * 式进行重构，重构前示例代码：
 */
class Computer {
    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;
    public Computer(String cpu, String screen, String memory, String mainboard) {
        this.cpu = cpu;
        this.screen = screen;
        this.memory = memory;
        this.mainboard = mainboard;
    }
}

class NewComputer {
    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;
    public NewComputer() {
        throw new RuntimeException("can’t init");
    }
    private NewComputer(Builder builder) {
        cpu = builder.cpu;
        screen = builder.screen;
        memory = builder.memory;
        mainboard = builder.mainboard;
    }
    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder() {}

        public Builder cpu(String val) {
            cpu = val;
            return this;
        }
        public Builder screen(String val) {
            screen = val;
            return this;
        }
        public Builder memory(String val) {
            memory = val;
            return this;
        }
        public Builder mainboard(String val) {
            mainboard = val;
            return this;
        }
        public NewComputer build() {
            return new  NewComputer(this);}
    }
}

class Click1 {
    public static void main(String[] args) {
        // 非 Builder 模式 
        Computer computer = new Computer("cpu", "screen", "memory", "mainboard");
        // Builder 模式 
        NewComputer newComputer = new NewComputer.Builder()
                .cpu("cpu")
                .screen("screen")
                .memory("memory")
                .mainboard("mainboard")
                .build();
    }
} 