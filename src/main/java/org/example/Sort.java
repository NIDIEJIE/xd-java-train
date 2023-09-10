package org.example;

import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入数组的长度：");
        int length = scanner.nextInt();

        int[] array = new int[length];

        System.out.println("请输入数组的元素：");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

//        insertionSort(array);
        shellSort(array);
        System.out.println("排序后的数组：");
        printArray(array);
    }

    //插入排序
    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            //大于待排序数，就往后移
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            //排序数正确位置
            array[j + 1] = key;
        }
    }
    public static void shellSort(int[] array) {
        int n = array.length;
        int gap = n / 2;
        while (gap > 0){
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;
                for (; j >= gap && array[j - gap] > temp; j = j - gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
            gap = gap / 2;
        }
    }
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
