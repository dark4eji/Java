package calculator;

import java.util.ArrayList;

public class RequestParser {

    private int[] operandsAndIndex = new int[4];
    private String[] operations = {"/", "*", "-", "+", "^"};
    private boolean isCorrectInput = true;

        public RequestParser() {
        }

        public void parseRequest(ArrayList<String> inputList) {

            for (int i = 0; i < inputList.size(); i++) {
                for (int j = 0; j < operations.length; j++) {
                    if (inputList.get(i).equals(operations[j])) {
                        operandsAndIndex[2] = inputList.indexOf(inputList.get(i));
                    }
                }
            }

            for (int i = 0; i < operations.length; i++) {
                if (inputList.get(operandsAndIndex[2]).equals(operations[i])) {
                    operandsAndIndex[3] = i + 1;
                }
            }

            String buffer1 = "";
            for (int i = 0; i < operandsAndIndex[2]; i++) {
                buffer1 += inputList.get(i);
            }

            String buffer2 = "";
            for (int b = operandsAndIndex[2] + 1; b < inputList.size(); b++) {
                 buffer2 += inputList.get(b);
            }
            operandsAndIndex[0] = Integer.parseInt(buffer1);
            operandsAndIndex[1] = Integer.parseInt(buffer2);
        }

        public int[] getValueArray(){
            return operandsAndIndex;
        }

        public void cleanValueArray(){
            for (int i = 0; i < operandsAndIndex.length; i++) {
                operandsAndIndex[i] = 0;
            }
        }

        public boolean getCorrectInputStatus(ArrayList<String> inputList){
            int count = 0;

            for (int i = 0; i < inputList.size(); i++) {
                for (int j = 0; j < operations.length; j++) {
                    if (inputList.get(i).equals(operations[j])) {
                        count += 1;
                    }
                    if (inputList.get(0).equals(operations[j])) {
                        isCorrectInput = false;
                    }
                }
            }

            if (count > 1){
                isCorrectInput = false;
            }
            return isCorrectInput;
        }

        public void setTrueStatus(){
            isCorrectInput = true;
        }
}


