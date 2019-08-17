package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());


        int minimum = min(a, b, c, d, e);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b, int c, int d, int e) {
        int[] nums = {a, b, c, d, e};
        for (int i = 0; i < 5; i++) {
            int temp;
            for (int g = 0; g < 5; g++) {
                if (nums[i] > nums[b]) {
                    temp = nums[b];
                    nums[i] = nums[b];
                    nums[b] = temp;
                }
            }
        }
        return nums[0];
    }
}
