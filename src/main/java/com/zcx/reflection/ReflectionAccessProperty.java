package com.zcx.reflection;

import java.lang.reflect.Field;

public class ReflectionAccessProperty {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.zcx.reflection.Student");
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        Field age = cls.getDeclaredField("age");
        age.set(o, 22);
        System.out.println(age.get(o));

        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "zcx");
        System.out.println(name.get(o));
    }
}

class Student {
    public int age;
    private static String name;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}