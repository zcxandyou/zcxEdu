package com.zcx.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectionExercise {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.zcx.reflection.PrivateTest");
        Object o = cls.newInstance();
        Field declaredField = cls.getDeclaredField("name");
        declaredField.setAccessible(true);
        declaredField.set(o, "helloworld");
        Method declaredMethod = cls.getDeclaredMethod("getName");
        Object invoke = declaredMethod.invoke(o);
        System.out.println(invoke);

    }
}

class PrivateTest {
    private String name = "helloKitty";

    public PrivateTest() {
    }

    public PrivateTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}