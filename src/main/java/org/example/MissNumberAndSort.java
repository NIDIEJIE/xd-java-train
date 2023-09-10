package org.example;

import java.util.Arrays;
import java.util.List;

public class MissNumberAndSort {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 11, 12, 13, 14, 15, 17, 18, 19, 20);

        int missingNumber = findMissingNumber(numbers);
        System.out.println("Missing number: " + missingNumber);

        sortNumbers(numbers);
        System.out.println("Sorted numbers: " + numbers);
    }

    private static int findMissingNumber(List<Integer> numbers) {
        int n = numbers.size() + 1;
        int expectedSum = (numbers.get(0) + numbers.get(numbers.size() - 1)) * n / 2;
        int totalSum = 0;

        for (int num : numbers) {
            totalSum += num;
        }

        return expectedSum - totalSum;
    }

    private static void sortNumbers(List<Integer> numbers) {
        numbers.sort(null);
    }
}
