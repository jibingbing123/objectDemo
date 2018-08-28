package com.object.staticFactoryMethod;

/**
 * 单例——饿汉优化版
 * 这种方式的优点在于,即使类被加载了,类也不一定被实例化,因为SingletonHolder内部类没有被主动使用;
 * 只有调用了getInstance方法才会实例化这个类
 * Created by jibingbing on 2017/12/17.
 */
public class BetterHungrySingleton {
    private static class SingletonHolder{
        private static final BetterHungrySingleton BETTER_HUNGRY_SINGLETON = new BetterHungrySingleton();
    }

    private BetterHungrySingleton(){}

    public static BetterHungrySingleton getInstance(){
        return SingletonHolder.BETTER_HUNGRY_SINGLETON;
    }
}
