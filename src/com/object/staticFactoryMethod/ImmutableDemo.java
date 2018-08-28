package com.object.staticFactoryMethod;

import java.util.Date;

/**
 * 通过采用保护性复制,其他程序无法获得与ImmutableDemo对象关联的两个Date对象的引用,
 * 这样即使Date类型的变量是可变的,外界也无法修改其变量的值
 * 什么时候需要保护性复制?
 * 当final修饰的属性是不可变类时,不需要保护性复制,但当final修饰的属性是Date这种可变时,需要.
 * Created by jibingbing on 2017/12/18.
 */
public class ImmutableDemo {
    private final Date start;
    private final Date end;

    public ImmutableDemo(Date start, Date end) {
        if(start.compareTo(end) > 0) throw new IllegalArgumentException(start + " after " + end);
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    public Date getStart() {
        return (Date) start.clone();
    }

    public Date getEnd() {
        return (Date) end.clone();
    }
}
