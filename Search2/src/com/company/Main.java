package com.company;
//Вывести числа в порядке возрастания (убывания) значений их длины.

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{342, 11, 3334, 1, 244444, 24449};
        int[] lenghtM = new int[nums.length];
        int longM = 0,  count = 0, was=0;
        int value = 0;

        for (int i = 0; i < nums.length; i++) {
            count = 0;
            was=nums[i];
            while (nums[i] % 10 > 0) {
                nums[i] = nums[i] / 10;
                count++;
            }
            lenghtM[i] = count;
            nums[i]=was;

        }
        System.out.println("was");
        for (int i = 0; i < nums.length; i++) {

            System.out.println("long   "+lenghtM[i]+"        "+"value   "+nums[i]);
        }

            System.out.println();
//sort min
//        for (int i = 0; i < lenghtM.length; i++) {
//            for (int j =i+1 ; j < lenghtM.length; j++) {
//                if (lenghtM[i] > lenghtM[j]) {
//                    longM = lenghtM[j];
//                    lenghtM[j] = lenghtM[i];
//                    lenghtM[i   ] = longM;
//                    value=nums[j];
//                    nums[j]=nums[i];
//                    nums[i]=value;
//                }
//            }
//
//        }
//        sort max
        for (int i = 0; i < lenghtM.length; i++) {
            for (int j =i+1 ; j < lenghtM.length; j++) {
                if (lenghtM[i] < lenghtM[j]) {
                    longM = lenghtM[j];
                    lenghtM[j] = lenghtM[i];
                    lenghtM[i   ] = longM;
                    value=nums[j];
                    nums[j]=nums[i];
                    nums[i]=value;
                }
            }

        }
        System.out.println("new");
        for (int i = 0; i < nums.length; i++) {
        System.out.println("long   "+lenghtM[i]+"        "+"value   "+nums[i]);
    }
}}