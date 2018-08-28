package com.object.staticFactoryMethod;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jibingbing on 2017/12/18.
 */
public class Name {
    private final String firtName;
    private final String lastName;
    private static final Set<SoftReference<Name>> names = new HashSet<SoftReference<Name>>();

    public Name(String firstName,String lastName) {
        this.firtName = firstName;
        this.lastName = lastName;
    }

    //静态工厂方法
    public static Name valueOf(String firstName, String lastName){
        for(SoftReference<Name> ref : names){
            Name name = ref.get();//获得软引用所引用的Name对象
            if(name != null
                    && name.firtName.equals(firstName)
                    && name.lastName.equals(lastName)){
                return name;
            }
        }
        //如果实例中不存在Name对象,将创建该对象,并把它的软引用加到实力缓存中
        Name name = new Name(firstName,lastName);
        names.add(new SoftReference<Name> (name));
        return name;
    }

    public static void main(String[] args) {
        Name n1 = Name.valueOf("小红","王");
        Name n2 = Name.valueOf("小红","王");
        Name n3 = Name.valueOf("小明","章");
        System.out.println(n1 == n2);
        System.out.println(n2 == n3);
    }
}
