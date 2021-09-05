package com.zcx.reflection.class_;

public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;
        Class<Iterable> cls2 = Iterable.class;
        Class<Integer[]> cls3 = Integer[].class;
        Class<float[][]> cls4 = float[][].class;
        Class<SuppressWarnings> cls5 = SuppressWarnings.class;
        Class<Integer> cls6 = int.class;
        Class<Void> cls7 = void.class;

        //枚举
        Class<Thread.State> cls8 = Thread.State.class;
        Class<Class> cls9 = Class.class;

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
    }
}
