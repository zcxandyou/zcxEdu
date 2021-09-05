package com.zcx.reflection.classload_;

public class ClassLoad02 {
    public static void main(String[] args) {

    }
}
class A{
    // 属性
    // 1.n1是实例属性，不说静态变量，因此在准备阶段是不会分配内存
    // 2.n2是静态变量，分配内存，n2是默认初始化，值为0
    // 3.N3是static final，所以是常量，和静态变量不一样，因此一旦赋值就不会变了
    public int n1 = 10;
    public static int n2 = 20;
    public static final int N3 = 30;
}