package com.object.staticFactoryMethod;

import java.util.EmptyStackException;

/**
 * Created by jibingbing on 2017/12/20.
 */
public class Stack {
    private Object[] element;
    private int size;
    private int increament = 10;

    public Stack(int initCapacity){
        element = new Object[initCapacity];
    }

    public Stack(int initCapacity,int increament){
        this(initCapacity);
        this.increament = increament;
    }

    private void ensureCapacity(){
        if(element.length == size){
            Object[] oldElement = element;
            element = new Object[element.length + increament];
            System.arraycopy(oldElement,0,element,0,size);
        }
    }

    public void push(Object object){
        ensureCapacity();
        element[size++] = object;
    }

    public Object pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        Object object = element[--size];
        element[size] = null;
        return object;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        for(int i = 0;i < 10;i++){
            stack.push(new Integer(i));
        }
        for(int i = 0;i < 10;i++){
            Object object = stack.pop();
//            System.out.println(object);
        }
    }
}
