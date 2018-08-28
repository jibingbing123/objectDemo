package com.object.staticFactoryMethod;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by jibingbing on 2017/12/17.
 */
public class Gender implements Serializable {
    //被final修饰的变量可以直接在声明的地方初始化,也可以在构造器里面初始化,但是必须要初始化,否则编译报错
    private final Character sex;
    private final transient String description;
    private static final Map<Character,Gender> instanceBySex = new HashMap<>();

    public Character getSex() {
        return sex;
    }

    public String getDescription() {
        return description;
    }

    public Gender(Character sex, String description) {
        this.sex = sex;
        this.description = description;
        instanceBySex.put(sex,this);
    }

    public static final Gender FEMALE = new Gender(new Character('F'),"Female");
    public static final Gender MALE = new Gender(new Character('M'),"Male");

    public static Gender getInstance(Character sex){
        Gender result = instanceBySex.get(sex);
        if(result == null){
            throw new NoSuchElementException(sex.toString());
        }
        return result;
    }

    public String toString(){
        return description;
    }
    /*
    * 保证反序列化时直接返回Gender类包含的静态实例
    * */
    private Object readRosolve(){
        return getInstance(sex);
    }
}
