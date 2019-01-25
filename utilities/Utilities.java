package utilities;

import java.util.Random;

public class Utilities {

    public Utilities() {
    }

    public static int[] generateArray(int SIZE, int RAND_BOUND) {
        Random rand = new Random();
        int[] arr = new int[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(RAND_BOUND);
        }
        return arr;
    }


}
