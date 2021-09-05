package com.zcx.reflection;

import java.lang.reflect.Constructor;

public class ReflectionCreateInstance {
    public static void main(String[] args) throws Exception {
        // 1.获取到User的class对象
        Class<?> cls = Class.forName("com.zcx.reflection.User");
        // 2.通过public的无参构造器创建实例
        Object o = cls.newInstance();
        System.out.println(o);
        // 3.通过public的有参构造器创建对象
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object o1 = constructor.newInstance("zenglingxue");
        System.out.println(o1);
        // 4.通过非public的有参构造器创建对象
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class, String.class);
        // 暴力破解
        declaredConstructor.setAccessible(true);
        Object o2 = declaredConstructor.newInstance(22, "woaini");
        System.out.println(o2);

    }
}

class User {
    private int age = 21;
    private String name = "zhengchuxuan";

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}