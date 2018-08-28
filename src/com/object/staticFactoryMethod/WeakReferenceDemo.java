package com.object.staticFactoryMethod;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 1.当一个对象仅持有弱引用时,如果没垃圾回收器回收,该弱引用就不会被加入到与之关联的引用队列中
 * Created by jibingbing on 2017/12/22.
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        //创建一个强引用
        String str = new String("hello");
        //创建引用队列
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        //创建一个弱引用,它引用hello对象,并与rq引用队列关联
        WeakReference<String> wf = new WeakReference<String>(str,rq);

        str = null;
        System.gc();
        System.gc();
        String str1 = wf.get();
        System.out.println(str1);

        Reference< ? extends String> ref = rq.poll();
        System.out.println("ref = " + ref);
    }
}
