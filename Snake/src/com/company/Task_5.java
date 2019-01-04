package com.company;

import java.util.Random;

public class Task_5 {
    public static void main(String[] args) {
        Random rand = new Random();

        int max_element = 0;
        int min_element = 0;
        final int ARR_SIZE = 15;  //Константа для хранения размера массива
        int[] array = new int[ARR_SIZE];

        for ( int i = 0; i < array.length; i++ ) {  //Цикл для динамической генерации содержимого массива
            int number = rand.nextInt(100);  //Генерирует случайное число
            array[i] = number;  //Добавляет случайное число в массив
        }

        for ( int j = 0; j < array.length; j++ ) {  //Цикл для поиска максимального и минимального элемента
            if (array[j] > array[max_element]) {
                max_element = j;
            } else if (array[j] < array[min_element]) {
                min_element = j;
            }
        }

        for ( int o : array ) {  //Цикл для вывода содержимого массива (для наглядности)
            System.out.print(o + " ");
        }

        System.out.println("\nМинимальное значение: " + array[min_element]
                + "\nМаксимальное значение: " + array[max_element]);
    }
}
