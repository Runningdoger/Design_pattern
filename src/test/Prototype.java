package test;

/**
 * 简化为clone方法，重写clone
 * 深拷贝与浅拷贝 深拷贝需将对象都实现clone，或者使用序列化
 */
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep=new Sheep("1","2",new Sheep("2","3"));
        Sheep sheep1=(Sheep)sheep.clone();
        sheep.show();
        sheep1.show();
    }
}

class Sheep implements Cloneable{
    private String name;
    private String color;
    private Sheep friend;
    public Sheep(String name, String color,Sheep friend) {
        this.name = name;
        this.color = color;
        this.friend=friend;
    }
    public Sheep(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    protected  Object clone() throws CloneNotSupportedException {

        Sheep sheep = (Sheep)super.clone();
        if(sheep.friend!=null) {
            sheep.friend = ((Sheep) sheep.friend.clone());
        }
        return sheep;
    }

    public void show(){
        System.out.println(friend.hashCode());
    }
}
