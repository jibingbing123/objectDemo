package com.object.staticFactoryMethod;

/**
 * 单例——饿汉
 * Created by jibingbing on 2017/12/17.
 */
public class HungrySingleton {
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    private HungrySingleton () {}

    public static HungrySingleton getInstance(){
        return HUNGRY_SINGLETON;
    }
}
