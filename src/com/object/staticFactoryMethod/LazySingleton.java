package com.object.staticFactoryMethod;

/**
 * 单例——懒汉
 * Created by jibingbing on 2017/12/17.
 */
public class LazySingleton {
    private static LazySingleton lazySingleton;

    private LazySingleton () {}

    public static LazySingleton getInstance () {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
