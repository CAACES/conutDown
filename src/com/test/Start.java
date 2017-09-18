package com.test;

/**
 * Created by Frank on 9/18/2017.
 */
public class Start {

    private static Threader threader = null;

    //mian方法
    public static void main(String[] args) {
        threader = new Threader();
        threader.start();
    }
}
