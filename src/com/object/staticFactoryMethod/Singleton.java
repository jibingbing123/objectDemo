package com.object.staticFactoryMethod;

import java.io.InputStream;
import java.util.Properties;

/**
 * 单例类是指仅有一个类的实例,在系统中唯一性的组件可作为单例类
 * Created by jibingbing on 2017/12/17.
 */
public class Singleton {
    private static final Singleton SINGLETON = new Singleton();
    private Properties properties = new Properties();

    private Singleton() {
        try {

            InputStream in = getClass().getResourceAsStream("myapp.properties");
            properties.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Singleton getInstance() {
        return SINGLETON;
    }

    public Properties getProperties() {
        return properties;
    }
}
