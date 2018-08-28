package com.object.test;

/**
 * Created by jibingbing on 2017/12/22.
 */
public class B extends A {
    B(int i){
        super(i);
        System.out.println(i);
    }

    public static void main(String[] args) {
        B b = new B(2);
    }
}
