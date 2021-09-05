package com.zcx.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();

        // 使用反射机制解决
        // 1. 加载类,返回Class类型的对象
        Class<?> cls = Class.forName(classfullpath);
        // 2.通过cls得到加载的类com.zcx.Cat的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型" + o.getClass());
        // 3.通过cls得到加载的类com.zcx.Cat的methodName方法对象
        //  即在反射中，可以把方法视为对象
        Method clsMethod = cls.getMethod(method);
        // 通过clsMethod调用方法：即通过方法对象来调用方法
        // 传统方法：对象.方法()  反射机制：方法.invoke(对象)
        clsMethod.invoke(o);

        // java.lang.reflect.Field:代表类的成员变量
        // getField()不能得到私有的属性
        Field age = cls.getField("age");
        System.out.println(age.get(o));

        // java.lang.reflect.Constructor:代表类的构造器
        // ()中可以指定构造器参数类型，默认返回无参构造器
        Constructor<?> constructor = cls.getConstructor();
        System.out.println(constructor);

        // String.class就是String的Class对象
        Constructor<?> constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);

        Constructor<?> constructor2 = cls.getConstructor(int.class);
        System.out.println(constructor2);
    }
}
