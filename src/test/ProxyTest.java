package test;

/**
 * 代理模式：
 * 由于某些原因需要给某对象提供一个代理以控制对该对象的访问。
 * 这时，访问对象不适合或者不能直接引用目标对象，代理对象作
 * 为访问对象和目标对象之间的中介。
 *
 * 应用场景：
 * 远程代理，这种方式通常是为了隐藏目标对象存在于不同地址空间的事实，方便客户端访问。
 * 例如，用户申请某些网盘空间时，会在用户的文件系统中建立一个虚拟的硬盘，用户访问虚
 * 拟硬盘时实际访问的是网盘空间。
 *
 * 虚拟代理，这种方式通常用于要创建的目标对象开销很大时。例如，下载一幅很大的图像需
 * 要很长时间，因某种计算比较复杂而短时间无法完成，这时可以先用小比例的虚拟代理替换
 * 真实的对象，消除用户对服务器慢的感觉。
 *
 *
 * 安全代理，这种方式通常用于控制不同种类客户对真实对象的访问权限。
 *
 * 智能指引，主要用于调用目标对象时，代理附加一些额外的处理功能。
 * 例如，增加计算真实对象的引用次数的功能，这样当该对象没有被引用时，
 * 就可以自动释放它。
 *
 * 延迟加载，指为了提高系统的性能，延迟对目标的加载。例如，Hibernate
 * 中就存在属性的延迟加载和关联表的延时加载。
 */
public class ProxyTest {
    public static void main(String[] args)
    {
        Proxy proxy=new Proxy();
        proxy.Request();
    }
}
//抽象主题
interface Sub {
    void Request();
}
//真实主题
class RealSubject implements Sub
{
    @Override
    public void Request()
    {
        System.out.println("访问真实主题方法...");
    }
}
//代理
class Proxy implements Sub
{
    private RealSubject realSubject;
    @Override
    public void Request()
    {
        if (realSubject==null)
        {
            realSubject=new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }
    public void preRequest()
    {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void postRequest()
    {
        System.out.println("访问真实主题之后的后续处理。");
    }
}