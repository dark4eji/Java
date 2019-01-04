package com.company;

public class Task_4 {
    public static void main(String[] args) {
        int size = 6;
        int[][] array = new int[size][size];

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                array[i][i] = 1;  //Заполняем диагональ слева направо сверху вниз
                array[i][(array[i].length - 1) - i] = 1;  //Заполняем диагональ справа налево сверху вниз
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
