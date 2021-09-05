package com.zcx.reflection.class_;

import java.lang.reflect.Field;

public class Class02 {
    public static void main(String[] args) throws Exception {
        String classAllPath = "com.zcx.Car";
        // 1.获取Car类对应的Class对象
        Class<?> cls = Class.forName(classAllPath);
        // 2.输出cls，显示cls对象是属于哪个类的Class对象
        System.out.println(cls);
        // 输出cls的运行类型
        System.out.println(cls.getClass());
        // 3.得到包名
        System.out.println(cls.getPackage().getName());
        // 4.得到全类名
        System.out.println(cls.getName());
        // 5.通过cls创建对象实例
        Object o = cls.newInstance();
        System.out.println(o);
        // 6.通过反射获取属性brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(o));
        // 7.通过反射给属性赋值
        brand.set(o,"audi");
        System.out.println(brand.get(o));
        // 8.获取所有的属性
        Field[] fields = cls.getFields();
        for (Field f: fields
             ) {
            System.out.println(f.getName() + ":" + f.get(o));

        }
    }
}
