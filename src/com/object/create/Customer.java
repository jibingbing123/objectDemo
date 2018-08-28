package com.object.create;

/**
 * 通过clone方式创建对象后,debug进入equals方法发现,
 * 克隆出来的对象并不是当前类的实例,这个对象只是拥有与Customer相同的属性
 * Created by jibingbing on 2017/12/16.
 */
public class Customer implements Cloneable {
    private String name;
    private int age;

    public Customer() {
        this("unknown",0);
        System.out.println("调用Customer的默认构造器...");
    }

    public Customer(String name,int age) {
        this.age = age;
        this.name = name;
        System.out.println("调用Customer带name和age参数的构造器...");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object o){
        if(this == o) return true;

        if(!(o instanceof Customer)) return false;

        final Customer other = (Customer) o;
        if(this.name.equals(other.name) && this.age == other.age){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "name = " + this.name + ", age = " + this.age;
    }

    public static void main(String[] args) {
        //通过反射方式创建对象
        try {
            Class objClass = Class.forName("com.object.create.Customer");
            Customer c1 = (Customer) objClass.newInstance();
            System.out.println("c1: " + c1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //通过new语句创建对象
        Customer c2 = new Customer("Jibingbing",22);
        System.out.println("c2: " + c2);

        //通过clone方法创建对象
        try {
            Customer c3 = (Customer) c2.clone();
            System.out.println("c2 == c3: " + (c2 == c3));
            System.out.println("c2.equals(c3): " + c2.equals(c3));
            System.out.println("c3: " + c3);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
