package calculator;

import java.util.ArrayList;

public class RequestReceiver {
    private ArrayList<String> valueArray = new ArrayList<String>();

    public RequestReceiver() {

    }

    public void addValue(String value) {
        valueArray.add(value);
    }

    public ArrayList<String> getArray(){
        return valueArray;
    }
    public void cleanArray() {
        valueArray.clear();
        valueArray.trimToSize();
    }
}

