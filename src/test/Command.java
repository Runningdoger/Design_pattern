package test;

/**
 * 在软件系统中，行为请求者与行为实现者通常是一种紧耦合的关系，
 * 但某些场合,比如需要对行为进行记录、撤销或重做、事务等处理
 * 时，这种无法抵御变化的紧耦合的设计就不太合适。
 *
 * 优点： 1、降低了系统耦合度。 2、新的命令可以很容易添加到系统
 * 中去。
 *
 * 缺点：使用命令模式可能会导致某些系统有过多的具体命令类。
 */

/**
 * 简单例子
 */
interface Command {
    void excute();
}

class Light{
    public void on(){
        System.out.println("开灯");
    }

     public void close(){
         System.out.println("关灯");
     }
}

class openLight implements Command{

    Light light;

    public openLight(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.on();
    }

}

class closeLight implements Command{

    Light light;

    public closeLight(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.close();
    }

}

class RemoteControl{
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void excute(Command command){
        command.excute();
    }

}


