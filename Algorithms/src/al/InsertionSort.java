package al;

public class InsertionSort {
    public static void sortByInsertion(int[] array) {

        for (int o : array) {
            System.out.print(o + " ");
        }

        System.out.println();

        for (int i = 0; i < array.length - 1; i++) {
            int temp = 0;
            int j = 0;
            if (array[i] > array[i + 1]) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                j = i;
                while (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
        for (int o : array) {
            System.out.print(o + " ");
        }
    }
}

