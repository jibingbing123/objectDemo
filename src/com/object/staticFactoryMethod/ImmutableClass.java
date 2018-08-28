package com.object.staticFactoryMethod;

/**
 * 不可变类是指当创建了这个类的实例后,就不允许修改它的属性值
 * 当创建不可变类时,可以考虑以下设计模式:
 * 1.把属性定义为private final类型
 * 2.不对外公开修改属性的setXXX()方法
 * 3.只对外公开读取属性的getXXX()方法
 * 4.在构造方法中初始化所有属性
 * 5.覆盖Object类的equals()和hashCode()方法
 * Created by jibingbing on 2017/12/18.
 */
public class ImmutableClass {
    private final String firstName;
    private final String lastName;

    public ImmutableClass(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof ImmutableClass)) return false;

        final ImmutableClass immutableClass = (ImmutableClass)o;
        if(immutableClass.firstName.equals(this.firstName) && immutableClass.lastName.equals(this.lastName)){
            return true;
        } else {
            return false;
        }
    }

    public int hashCode(){
        int result;
        result = (firstName == null ? 0 : firstName.hashCode());
        result = 29 * result + (lastName == null ? 0 : lastName.hashCode());
        return result;
    }

    public String toString(){
        return "firstName = " + firstName + ", lastName = " + lastName;
    }
}
