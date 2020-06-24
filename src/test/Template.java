package test;

/**
 * 模板模式
 * 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该
 * 算法的某些特定步骤。
 *
 * 使用场景： 1、有多个子类共有的方法，且逻辑相同。
 * 2、重要的、复杂的方法，可以考虑作为模板方法。
 *
 * 以下只是一个最简单的例子，对于子类相同的方法，可以
 * 放在抽象类中实现，另外，抽象类也可以有钩子方法，用来实现
 * 子类可有可不有的方法，也可以让子类有机会对模板方法中即将发生
 * 的步骤做出反应。
 */
abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}

class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}

class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
