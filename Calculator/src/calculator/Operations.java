package calculator;

public class Operations {
    private boolean isDividedByZero = false;

    public int countPower(int number, int power) {
        int powerResult = number;
        for (int i = 1; i < power; i++) {
            powerResult *= number;
        }
        return powerResult;
    }

    public int countSum(int fSum, int sSum) {
        return fSum + sSum;
    }

    public int countSubtraction(int fSub, int sSub) {
        return fSub - sSub;
    }

    public int countMultiplication(int fMult, int sMult) {
        return fMult * sMult;
    }

    public int countDivision(int fDiv, int sDiv) {
        if (sDiv != 0) {
            return fDiv / sDiv;
        } else {
            isDividedByZero = true;
            return 0;
        }
    }

    public boolean getDividedByZeroStatus(){
        return isDividedByZero;
    }

    public void setFalseZeroStatus(){
        isDividedByZero = false;
    }



//    public double countDivision(double fDiv, double sDiv) {
//        if (sDiv != 0) {
//            return fDiv / sDiv;
//        } else {
//            return 0;
//        }
//    }
}
