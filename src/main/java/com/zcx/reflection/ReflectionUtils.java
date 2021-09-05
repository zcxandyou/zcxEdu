package com.zcx.reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_01() throws Exception {
        // 1.得到class对象
        Class<?> cls = Class.forName("com.zcx.reflection.Person");
        System.out.println("==========");

        // 2.getName:获取全类名
        String name = cls.getName();
        System.out.println(name);
        System.out.println("==========");

        // 3.getSimpleName:获取简单类名
        String simpleName = cls.getSimpleName();
        System.out.println(simpleName);
        System.out.println("==========");

        // 4.getFields:获取所有public修饰的属性，包括本类及父类
        Field[] fields = cls.getFields();
        for (Field field : fields
        ) {
            System.out.println(field + " + " + field.getName());
        }
        System.out.println("==========");

        // 5.getDeclaredFields:获取本类中的所有属性
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("==========");

        // 6.getMethods:获取所有public修饰的方法，包括父类(父类的父类)和本类
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("==========");

        // 7.getDeclaredMethods:获取本类的所有方法
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("==========");

        // 8.getConstructors：获取所有public修饰的构造器，包括本类及父类
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("==========");

        // 9.getDeclaredConstructors:获取本类所有的构造器
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("==========");

        // 10.getPackage:以Package形式返回包信息
        Package clsPackage = cls.getPackage();
        System.out.println(clsPackage);
        System.out.println("==========");

        // 11.以Class形式返回父类信息
        Class<?> superclass = cls.getSuperclass();
        System.out.println(superclass);
        System.out.println("==========");

        // 12.getInterfaces:以接口形式返回所有信息
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        System.out.println("==========");

        // 13.getAnnotations:以Annotataions[]返回注解信息
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @Test
    public void api_02() throws Exception{
        Class<?> cls = Class.forName("com.zcx.reflection.Person");
        Field[] declaredFields = cls.getDeclaredFields();
        // getModifiers:获取属性值
        // default:0
        // public:1
        // protected:4
        // private:2
        // final:16
        // static:8
        // getType:以Class形式返回类型
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField + "该属性的修饰值是：" + declaredField.getModifiers() +
                    "该属性的类型是：" + declaredField.getType());

        }

        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类的所有方法是：" + declaredMethod.getName()
            + "该方法的访问修饰符值是：" + declaredMethod.getModifiers()
            + "该方法的返回值类型是：" + declaredMethod.getReturnType());

            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
        }
    }
}

class A {
    public String hobby;

    public void m5() {

    }

    public A() {
    }

    public A(String hobby) {
        this.hobby = hobby;
    }
}

interface IA {

}

@SuppressWarnings({"all"})
@Deprecated
class Person extends A implements IA {
    // 属性
    public String name;
    protected int age;
    String job;
    private double salary;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, String job, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }

    // 方法
    public void m1() {
        System.out.println("m1");
    }

    protected void m2() {
        System.out.println("m2");
    }

    void m3() {
        System.out.println("m3");
    }

    private void m4() {
        System.out.println("m4");
    }
}