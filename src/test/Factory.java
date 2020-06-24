package test;


/**
 * 由一个工厂对象决定创建出哪一种产品类的实例
 * 定义了一个创建对象的类，封装了实例化对象行为
 * 当会用到大量创建某种、某类或这某批对象，就可以使用工厂模式
 */

/**
 * 简单工厂模式
 */
class SimpleFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

/**
 * 定义创建对象的抽象方法，由子类决定要实例化的类，将实例化
 * 推迟到子类
 */
interface Factory {
    Phone makePhone();
}

class XiaoMiFactory implements Factory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}

class AppleFactory implements Factory {
    @Override
    public Phone makePhone() {
        return new IPhone();
    }
}

interface Phone {
    void make();
}

class MiPhone implements Phone {
    public MiPhone() {
        this.make();
    }
    @Override
    public void make() {
        // TODO Auto-generated method stub
        System.out.println("make xiaomi phone!");
    }
}

class IPhone implements Phone {
    public IPhone() {
        this.make();
    }
    @Override
    public void make() {
        // TODO Auto-generated method stub
        System.out.println("make iphone!");
    }
}


/**
 * 抽象工厂模式
 * 相当于 上述不仅遭手机，又开始建 PC，只需在Factory中加入造PC的方法就可以
 *
 */
