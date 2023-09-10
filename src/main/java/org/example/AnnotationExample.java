package org.example;

import org.example.annotation.MyAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationExample {

    public static void main(String[] args) {
        // 获取类上的注解信息
        Class<AnnotationTest> clazz = AnnotationTest.class;
        MyAnnotation classAnnotation = clazz.getAnnotation(MyAnnotation.class);
        if (classAnnotation != null) {
            System.out.println("Class Annotation Value: " + classAnnotation.value());
            System.out.println("Class Annotation Count: " + classAnnotation.count());
        }

        // 获取方法上的注解信息
        Method method = null;
        try {
            method = clazz.getDeclaredMethod("myMethod");
            MyAnnotation methodAnnotation = method.getAnnotation(MyAnnotation.class);
            if (methodAnnotation != null) {
                System.out.println("Method Annotation Value: " + methodAnnotation.value());
                System.out.println("Method Annotation Count: " + methodAnnotation.count());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 获取字段上的注解信息
        Field field = null;
        try {
            field = clazz.getDeclaredField("myField");
            MyAnnotation fieldAnnotation = field.getAnnotation(MyAnnotation.class);
            if (fieldAnnotation != null) {
                System.out.println("Field Annotation Value: " + fieldAnnotation.value());
                System.out.println("Field Annotation Count: " + fieldAnnotation.count());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}