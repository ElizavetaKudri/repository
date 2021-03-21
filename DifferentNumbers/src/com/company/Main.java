package com.company;

//Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
public class Main {

    public static void main(String[] args) {

        int[] nums = new int[]{243, 11, 3334, 1, 244442, 24449};
//        int[] diff = new int[nums.length];
        int was = 0;


        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            int last = 0, newNum = 0, newNew = 0;
            was = nums[i];
            newNum = was;
            while (was > 0 && flag) {
                last = was % 10;
                newNum = was / 10;
                while (newNum % 10 > 0) {
                    newNew = newNum % 10;
                    newNum = newNum / 10;
                    if (last == newNew) {
                        nums[i] = 0;
                        flag = false;
                    }

                }
                was = was / 10;

            }


        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                System.out.println(nums[i]);
                break;
            }
        }
    }
}



