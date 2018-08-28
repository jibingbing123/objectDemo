package com.object.staticFactoryMethod;

/**
 * Integer类通过静态工厂方法valueOf()做了实力缓存;
 * 调用valueOf()方法时,如果实力缓存中有取值为i的实例,直接返回这个实例,
 * 如果没有,创建一个取值为i的实例,把这个实例放入缓存中,返回这个实例.
 * 通过查看源码发现Integer实例缓存的范围在-128~128之间,超过这个范围就直接创建一个实例
 * Created by jibingbing on 2017/12/18.
 */
public class IntegerDemo {
    public static void main(String[] args) {
        Integer integer1 = new Integer(10);
        Integer integer2 = new Integer(10);
        Integer integer3 = Integer.valueOf(10);
        Integer integer4 = Integer.valueOf(10);
        Integer integer5 = Integer.valueOf(129);
        Integer integer6 = Integer.valueOf(129);

        System.out.println(integer1 == integer2);
        System.out.println(integer1 == integer3);
        System.out.println(integer3 == integer4);
        System.out.println(integer5 == integer6);
    }
}
