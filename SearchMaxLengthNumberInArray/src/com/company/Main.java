package com.company;

import java.util.Arrays;

//  Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{342, 11, 3334, 1, 244444, 244449};
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        int[] nums1 = new int[nums.length];
        int min = 0, max = 0, count = 0;
        int minCount = 0, maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            count = 0;
            while (nums[i] % 10 > 0) {
                nums[i] = nums[i] / 10;
                count++;
            }
            nums1[i] = count;


        }

        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i - 1] > nums1[i]) {
                min = nums1[i];
                minCount = i;
            }
            if (nums1[i - 1] < nums1[i]) {
                max = nums1[i];
                maxCount = i;
            }

        }

        System.out.println("min=" + copyNums[minCount] + "   length=" + min);
        System.out.println("max=" + copyNums[maxCount] + "    length=" + max);
    }
}