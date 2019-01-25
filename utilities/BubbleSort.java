package utilities;

public class BubbleSort {

    public BubbleSort(){

    }

    public static void sortBubble(int[] array) {
        int check;
        do {
            check = -1;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int buffer;
                    buffer = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = buffer;
                    check++;
                }
            }
        } while (check != -1);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
