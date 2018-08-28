package com.object.staticFactoryMethod;

/**
 * Created by jibingbing on 2017/12/17.
 */
public class Person {
    private String name;
    private Gender gender;

    public Person(String name,Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public static void main(String[] args) {
        Person mary = new Person("Mary",Gender.FEMALE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
