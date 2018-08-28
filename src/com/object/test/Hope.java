package com.object.test;

/**
 * Created by jibingbing on 2017/12/22.
 */
public class Hope {
    protected Hope(){
        for(int i = 0;i < 10;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Hope hope = new Hope();
    }
}
