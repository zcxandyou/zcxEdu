package com.zcx.reflection.question;

import com.zcx.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author zhengchuxuan
 * 发射问题的引入
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 传统的方式
        Cat cat = new Cat();
        cat.hi();
        // 使用propeties类
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();
        System.out.println(classfullpath);
        System.out.println(method);

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
    }
}
