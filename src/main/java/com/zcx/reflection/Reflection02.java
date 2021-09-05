package com.zcx.reflection;

import com.zcx.Cat;
import sun.nio.cs.ext.MacThai;

import java.lang.reflect.Method;

public class Reflection02 {
    public static void main(String[] args) throws Exception {
        Reflection02 reflection02 = new Reflection02();
        reflection02.m1();
        reflection02.m2();
    }
    // 传统方法
    public void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    // 反射机制
    public void m2() throws Exception {
        Class<?> cat = Class.forName("com.zcx.Cat");
        Object o = cat.newInstance();
        Method method = cat.getMethod("hi");
//        method.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            method.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
