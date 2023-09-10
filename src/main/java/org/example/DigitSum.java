package org.example;

import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入：");
        int number = input.nextInt();
        int digitSum = calculateDigitSum(number);
        System.out.println("各个位数的和为：" + digitSum);
    }

    public static int calculateDigitSum(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;  // 取最后一位数字
            sum += digit;  // 累加最后一位数字
            num /= 10;  // 去掉最后一位数字
        }

        return sum;
    }
}