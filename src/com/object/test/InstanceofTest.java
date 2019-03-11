package com.object.test;

public class InstanceofTest {

    public static void main(String[] args) {
        B b = new B(1);
        System.out.println(b instanceof A);

        A a = new A(2);
        System.out.println(a instanceof B);
    }
}
