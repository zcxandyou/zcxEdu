package com.zcx.reflection.class_;

import com.zcx.Cat;

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // Class类图
        // 1.Class也是类，因此也继承Object类
        // 2.Class类对象表示new出来的，是系统创建出来的
        // (1)传统new对象
        /*  ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
             }
        */
        Cat cat = new Cat();
        // (2)反射方式
        /*  public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
             }
        */
        Class<?> cls1 = Class.forName("com.zcx.Cat");

        // 3.对于某个类的Class对象，在内存中只有一份，因此类只加载一次
        Class<?> cls2 = Class.forName("com.zcx.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        Class<?> cls3 = Class.forName("com.zcx.Dog");
        System.out.println(cls3.hashCode());

        // 类的字节码二进制文件是放在方法区的，有的地方成为元数据（包括方法代码、变量名、方法名、访问权限等等）
    }
}
