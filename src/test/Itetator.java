package test;

import java.util.ArrayList;
import java.util.List;

/**+
 * 迭代器模式
 * 提供一个对象来顺序访问聚合对象中的一系列数据，
 * 而不暴露聚合对象的内部表示。迭代器模式是一种对象行为型模式，其主要优点如下。
 *
 * 访问一个聚合对象的内容而无须暴露它的内部表示。
 *
 * 遍历任务交由迭代器完成，这简化了聚合类。
 *
 * 它支持以不同方式遍历一个聚合，甚至可以自定义迭代器的子类以支持新的遍历。
 *
 * 增加新的聚合类和迭代器类都很方便，无须修改原有代码。
 *
 * 封装性良好，为遍历不同的聚合结构提供一个统一的接口。
 */
class IteratorPattern
{
    public static void main(String[] args)
    {
        Aggregate ag=new ConcreteAggregate();
        ag.add("中山大学");
        ag.add("华南理工");
        ag.add("韶关学院");
        System.out.print("聚合的内容有：");
        It it=ag.getIterator();
        while(it.hasNext())
        {
            Object ob=it.next();
            System.out.print(ob.toString()+"\t");
        }
        Object ob=it.first();
        System.out.println("\nFirst："+ob.toString());
    }
}
//抽象聚合
interface Aggregate
{
    public void add(Object obj);
    public void remove(Object obj);
    public It getIterator();
}
//具体聚合
class ConcreteAggregate implements Aggregate
{
    private List<Object> list=new ArrayList<Object>();
    @Override
    public void add(Object obj)
    {
        list.add(obj);
    }
    @Override
    public void remove(Object obj)
    {
        list.remove(obj);
    }
    @Override
    public It getIterator()
    {
        return(new ConcreteIterator(list));
    }
}
//抽象迭代器
interface It
{
    Object first();
    Object next();
    boolean hasNext();
}
//具体迭代器
class ConcreteIterator implements It
{
    private List<Object> list=null;
    private int index=-1;
    public ConcreteIterator(List<Object> list)
    {
        this.list=list;
    }
    @Override
    public boolean hasNext()
    {
        if(index<list.size()-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public Object first()
    {
        index=0;
        Object obj=list.get(index);;
        return obj;
    }
    @Override
    public Object next()
    {
        Object obj=null;
        if(this.hasNext())
        {
            obj=list.get(++index);
        }
        return obj;
    }
}