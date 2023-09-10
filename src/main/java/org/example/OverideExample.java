package org.example;

import org.example.parent.Animal;
import org.example.son.Dog;

public class OverideExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();
        Dog dog = new Dog();
        dog.makeSound();
        dog.fetch();

        // 通过父类引用调用被子类重写的方法
        Animal animal2 = new Dog();
        animal2.makeSound();
    }
}
