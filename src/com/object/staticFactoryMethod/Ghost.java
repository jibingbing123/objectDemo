package com.object.staticFactoryMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * finalize()方法的特点:
 * 1.垃圾回收器是否执行该方法,什么时候执行该方法都是不确定;
 * 2.finalize()方法有可能使对象复活,使它恢复到可触及状态
 * 3.垃圾回收器在执行finalize()方法时,如果遇到异常,垃圾回收器不会报告异常,程序正常运行
 * Created by jibingbing on 2017/12/20.
 */
public class Ghost {
    //实例缓存
    private static final Map<String,Ghost> ghosts = new HashMap<>();
    private String name;

    public Ghost(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*
    * 获取实例对象时,如果实例缓存里有与name匹配的Ghost对象时,直接返回该对象;
    * 如果没有,则创建一个新的实例对象,并且把这个对象放到实例缓存里
    */
    public static Ghost getInstance(String name){
        Ghost ghost = ghosts.get(name);
        if(ghost == null){
            ghost = new Ghost(name);
            ghosts.put(name,ghost);
        }
        return ghost;
    }

    //从缓存中删除指定name对应的实例对象
    public static void removeInstance(String name){
        ghosts.remove(name);
    }

    //finalize()方法把当前实例重新加载到缓存中
    protected void finalize() throws Throwable{
        ghosts.put(name,this);
        System.out.println("执行finalize()方法...");
        throw new Exception("test");
    }

    public static void main(String[] args) throws Exception {
        //先创建一个Ghost对象,打印出这个对象的信息
        Ghost ji = Ghost.getInstance("ji");
        System.out.println(ji);
        String jiName = ji.getName();
        //将指向这个对象的变量指向null后,堆中Ghost对象依然被ghosts属性间接引用
        ji = null;
        //将ghosts中指向Ghost对象的引用删除后,堆中已没有任何指向Ghost对象的引用了,此时Ghost对象成为了无用对象
        Ghost.removeInstance(jiName);
        //调用垃圾回收方法,并把CPU让给垃圾回收线程
        System.gc();
        Thread.sleep(3000);
        //重新获取name为ji的实例对象,打印观察是不是缓存中之前创建的
        //如果是之前创建,说明执行finalize方法后,垃圾回收器将无用的Ghost对象恢复成可触及状态
        ji = Ghost.getInstance("ji");
        System.out.println(ji);
    }
}
