package com.zcx.reflection.classload_;

public class ClassLoad03 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.加载B类，生成B的Class对象
        // 2.连接 num = 0；
        // 3.初始化阶段
        /*
        *       cInit(){
        *           System.out.println("B 静态代码块被执行");
                    num = 300;
        *           num = 100;
        *       }
        *       合并：num = 100;
        *
        * */
//        System.out.println(B.num);
        B b = new B();


    }
}

class B{
    static{
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public B() {
        System.out.println("B 构造器被执行");
    }
}