package com.zcx.reflection.class_;

import com.zcx.Car;

public class GetClass {
    public static void main(String[] args) throws Exception {
        // 1.Class.forName(),通过读取配置文件获取
        Class<?> cls1 = Class.forName("com.zcx.Car");
        System.out.println(cls1);

        // 2.类名.class，多用于参数传递
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        // 3.对象.getClass()，用于已经有对象实例
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        // 4.通过类加载器[4种]获取到类的Class对象
        // (1)先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        // (2)通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass("com.zcx.Car");
        System.out.println(cls4);

        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        // 5.基本数据按如下方式得到Classs对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);
        System.out.println(characterClass);
        System.out.println(booleanClass);

        // 6.基本数据类型对应的包装类，可以通过 包装类.TYPE得到Class对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE;
        Class<Boolean> type3 = Boolean.TYPE;
        System.out.println(type1);
        System.out.println(type2);
        System.out.println(type3);

        System.out.println(integerClass.hashCode());
        System.out.println(type1.hashCode());

    }
}
