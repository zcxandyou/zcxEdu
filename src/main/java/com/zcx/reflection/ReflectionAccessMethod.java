package com.zcx.reflection;

import java.lang.reflect.Method;

public class ReflectionAccessMethod {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.zcx.reflection.Boss");
        Object o = cls.newInstance();
        Method hi = cls.getDeclaredMethod("hi", String.class);
        hi.invoke(o, "zhengchuxuan");
        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        Object invoke = say.invoke(null, 11, "zhengchuxuan", 'c');
        System.out.println(invoke);
    }
}

class Boss {
    public int age;
    private static String name;

    private static String say(int n, String s, char c){
        return n + "" + s + "" + c;
    }

    public void hi(String s){
        System.out.println("boss.hi()");
    }
    @Override
    public String toString() {
        return "Boss{" +
                "age=" + age +
                '}';
    }
}