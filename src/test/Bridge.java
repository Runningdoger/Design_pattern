package test;

/**
 * 桥接模式 将实现与抽象放在两个不同的类层次中，
 * 使两个层次可以独立改变
 * 基于类的最小设计原则，
 * 通过封装、聚合、继承等让不同的类承担不同的职责，主要特点是
 * 把抽象和行为实现分离开来，从而保持各部分独立性以及应对他们
 * 功能扩展
 * 1、如果一个系统需要在构件的抽象化角色和具体化角色之间增加
 * 更多的灵活性，避免在两个层次之间建立静态的继承联系，通过
 * 桥接模式可以使它们在抽象层建立一个关联关系。
 * 2、对于那些不希望使用继承或因为多层次继承导致系统类的个数
 * 急剧增加的系统，桥接模式尤为适用。
 * 3、一个类存在两个独立变化的维度，且这两个维度都需要进行扩
 * 展。
 *
 * 注意事项：对于两个独立变化的维度，使用桥接模式再适合不过了。
 */


/**
 * 现需要提供大中小3种型号的画笔，能够绘制5种不同颜色，如果使
 * 用蜡笔，我们需要准备3*5=15支蜡笔，也就是说必须准备15个具体
 * 的蜡笔类。而如果使用毛笔的话，只需要3种型号的毛笔，外加5个
 * 颜料盒，用3+5=8个类就可以实现15支蜡笔的功能。本实例使用桥接
 * 模式来模拟毛笔的使用过程。
 */

/**
 * 用的笔 有3个类型大小
 */
abstract class Pen
{
    protected Color color;
    public void setColor(Color color)
    {
        this.color=color;
    }
    public abstract void draw(String name);
}

class SmallPen extends Pen
{
    @Override
    public void draw(String name)
    {
        String penType="小号毛笔绘制";
        this.color.bepaint(penType,name);
    }
}

class BigPen extends Pen
{
    @Override
    public void draw(String name)
    {
        String penType="大号毛笔绘制";
        this.color.bepaint(penType,name);
    }
}

class MiddlePen extends Pen
{
    @Override
    public void draw(String name)
    {
        String penType="中号毛笔绘制";
        this.color.bepaint(penType,name);
    }
}

/**
 * 相当于“桥”，准确点是，抽象类笔和这个颜色接口是桥的两端
 */
interface Color
{
    void bepaint(String penType,String name);
}

class Red implements Color
{
    @Override
    public void bepaint(String penType, String name)
    {
        System.out.println(penType + "红色的"+ name + ".");
    }
}

class Green implements Color
{
    @Override
    public void bepaint(String penType, String name)
    {
        System.out.println(penType + "绿色的"+ name + ".");
    }
}


class Blue implements Color
{
    @Override
    public void bepaint(String penType, String name)
    {
        System.out.println(penType + "蓝色的"+ name + ".");
    }
}

class White implements Color
{
    @Override
    public void bepaint(String penType, String name)
    {
        System.out.println(penType + "白色的"+ name + ".");
    }
}

class Black implements Color
{
    @Override
    public void bepaint(String penType, String name)
    {
        System.out.println(penType + "黑色的"+ name + ".");
    }
}

