package calculator;

public class Computer {

    public Computer() {
    }

    public int computeRequest(int[] valueArray, Operations operation) {
        int value = 0;
        if (valueArray[3] == 5) {
            value = operation.countPower(valueArray[0], valueArray[1]);
        }

        if (valueArray[3] == 4) {
            value = operation.countSum(valueArray[0], valueArray[1]);
        }

        if (valueArray[3] == 3) {
            value = operation.countSubtraction(valueArray[0], valueArray[1]);
        }

        if (valueArray[3] == 2) {
            value = operation.countMultiplication(valueArray[0], valueArray[1]);
        }

        if (valueArray[3] == 1) {
            value = operation.countDivision(valueArray[0], valueArray[1]);
        }

        return value;
    }
}
