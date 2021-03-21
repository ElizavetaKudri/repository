package com.company;

//Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 549, 123};
        int[] copyNums = new int[nums.length];
        int was = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            boolean end=false;
            boolean flag1 = false;

            was = nums[i];
            int last = was % 10;
            while (was % 10 > 0 && flag) {
                last = was % 10;
//                was = was / 10;
//                int newNum = was / 10;

                while (was % 10 > 0) {
                    was=was/10;
                    if (last <= (was % 10)) {
                        flag = false;
                        flag1 = true;
                        break;
//                    end=true;
                    }
                    if (end) continue;

                }


            }
            if (flag1) continue;
            System.out.println(nums[i]);

//недоделанно
        }
    }
}
