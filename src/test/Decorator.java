package test;

/**
 * 装饰者模式
 * 动态的将新功能附加到对象上。在对象功能扩展方面
 * 比继承更有弹性，也体现了开闭原则
 * 通常和工厂模式、建造者模式一起使用
 */
abstract class Beverage	//装饰者与被装饰者共享的超类，这里是个抽象类
{
    String description = "Unknown Beverage";	//饮料描述，此时为未知饮料
    public String getDescription()	//获取饮料描述的方法
    {
        return description;
    }
    public abstract double cost();	//抽象方法，获取价格金额
}


abstract class CondimentDecorator extends Beverage	//为装饰者的实现写的一个抽象类，所有装饰者继承该类
{
    @Override
    public abstract String getDescription();	//装饰者内部需要重写获取描述的方法，因为每装饰一次，就添加了新的配料
}


class Espresso extends Beverage	//具体化了一个饮料类，黑咖啡
{
    public Espresso()
    {
        description = "espresso";	//描述变更为黑咖啡
    }
    @Override
    public double cost()
    {
        return 1.99;	//返回黑咖啡价格
    }
}

class HouseBlend extends Beverage	//具体化了一个饮料类，混合咖啡
{
    public HouseBlend()
    {
        description = "houseblend";	//描述变更为混合咖啡
    }
    @Override
    public double cost()
    {
        return .89;	//返回混合咖啡的价格
    }
}

class Mocha extends CondimentDecorator	//具体化了一个配料类，摩卡
{
    Beverage beverage;	//声明一个Beverage是为了保存被装饰者的品种，方便根据该品种描述与价格计算装饰后的描述与价格
    public Mocha(Beverage bever)
    {
        this.beverage = bever;	//构造器里设置当前被装饰者品种
    }
    @Override
    public String getDescription()
    {
        return beverage.getDescription() + ",mocha"; //返回被装饰者与本装饰者mocha叠加的名称
    }
    @Override
    public double cost()
    {
        return beverage.cost() + .20;	//返回装饰者与被装饰者的价格之和
    }
}

class Whip extends CondimentDecorator	//具体化了一个配料类，奶泡，以下代码功能与mocha配料一致
{
    Beverage beverage;
    public Whip(Beverage bever)
    {
        this.beverage = bever;
    }
    @Override
    public String getDescription()
    {
        return beverage.getDescription() + ",whip";
    }
    @Override
    public double cost()
    {
        return beverage.cost() + .41;
    }
}

class decorate {

    public static void main(String[] args) {
        Beverage espresso1 = new Espresso();    //实例化一个espresso对象
        System.out.println(espresso1.getDescription() + ":" + espresso1.cost()); //输出只有espresso没有配料的描述与价格
        espresso1 = new Mocha(espresso1);    //用Mocha配料装饰espresso，装饰的过程即创建一个装饰者对象的过程，把被装饰者作为形参传递进去，结合该装饰者信息与装饰者信息结合，制造出一个装饰后的对象
        System.out.println(espresso1.getDescription() + ":" + espresso1.cost());    //输出espresso被mocha装饰后的描述与价格
        espresso1 = new Whip(espresso1);    //继续用whip装饰被mocha装饰后的espresso
        System.out.println(espresso1.getDescription() + ":" + espresso1.cost());    //输出被两种配料装饰后的描述与价格
    }

}