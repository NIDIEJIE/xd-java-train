package org.example;

import org.example.annotation.MyAnnotation;

@MyAnnotation(value = "Class Annotation", count = 2)
public class AnnotationTest {

    @MyAnnotation(value = "Method Annotation")
    public void myMethod() {
        // 方法体
    }

    @MyAnnotation(value = "Field Annotation")
    private String myField;
}