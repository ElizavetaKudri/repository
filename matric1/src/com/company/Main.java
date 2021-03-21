package com.company;

import java.util.Random;

//Задание. Ввести с консоли n - размерность матрицы a [n] [n].
// Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора
// случайных чисел (класс Random).
//2.     Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
public class Main {

    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = {{4, 10, 5, 0, 10},
                {2, 7, 13, 4, 0},
                {2, 7,8, 9, 10},
                {2, 7, 0, 4, 0},
                {2, 7, 0, 4, 0}};

        int a = 0;
        int b = 15;

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = a + (int) (Math.random() * b);
//                System.out.print(matrix[i][j] + "\t");
//
//            }
//            System.out.println();
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(matrix[i][j] + "\t");

            }
            System.out.println();
        }
        int print = 0;

        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 0; j < n - 1; j++) {

                if (matrix[i][j] > matrix[i][j + 1]) {
                    temp = 1;
                    continue;
                }
                temp++;

                if (temp >= 2) {
                    if (temp>print) {
                        print = temp;


                    }
            }



            }

        }
        System.out.println(print);



    }
}
