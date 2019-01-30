package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static String text = "";
    public static void GUI() {
        RequestReceiver receiver = new RequestReceiver();
        RequestParser parser = new RequestParser();
        Computer comp = new Computer();
        Operations ops = new Operations();

        JFrame frame = new JFrame("Calculator");
        JTextField field = new JTextField(30);
        JPanel contents1 = new JPanel();
        JPanel grid = new JPanel();
        JPanel grid2 = new JPanel();
        JPanel grid3 = new JPanel();

        Font font1 = new Font("Segoe UI", Font.BOLD, 40);

        GridLayout flowlayout = new GridLayout(2, 1, 5, 30);
        GridLayout layout = new GridLayout(1, 2, 5,15);
        GridLayout layout2 = new GridLayout(4, 4, 5, 12);
        GridLayout layout3_1 = new GridLayout(3, 2, 5, 12);
        contents1.setLayout(flowlayout);
        grid.setLayout(layout);
        grid2.setLayout(layout2);
        grid3.setLayout(layout3_1);

        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btnCancel = new Button("Сброс");
        Button btnSub = new Button("-");
        Button btnPlus = new Button("+");
        Button btnMult = new Button("*");
        Button btnDiv = new Button("/");
        Button btnPow = new Button("^");
        Button btnEquals = new Button("=");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(380, 340));
        frame.setResizable(false);
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setFont(font1);
        field.setEditable(false);
        field.setText("0");

        grid2.add(btn1);
        grid2.add(btn2);
        grid2.add(btn3);
        grid2.add(btn4);
        grid2.add(btn5);
        grid2.add(btn6);
        grid2.add(btn7);
        grid2.add(btn8);
        grid2.add(btn9);
        grid2.add(btn0);
        grid2.add(btnCancel);
        grid3.add(btnPlus);
        grid3.add(btnSub);
        grid3.add(btnDiv);
        grid3.add(btnMult);
        grid3.add(btnPow);
        grid3.add(btnEquals);

        contents1.add(field);
        grid.add(grid2);
        grid.add(grid3);
        contents1.add(grid);

        ActionListener listener0 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("0");
                text += "0";
                field.setText(text);
            }
        };

        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("1");
                text += "1";
                field.setText(text);
            }
        };

        ActionListener listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("2");
                text += "2";
                field.setText(text);
            }
        };

        ActionListener listener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("3");
                text += "3";
                field.setText(text);
            }
        };

        ActionListener listener4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("4");
                text += "4";
                field.setText(text);
            }
        };

        ActionListener listener5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("5");
                text += "5";
                field.setText(text);
            }
        };

        ActionListener listener6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("6");
                text += "6";
                field.setText(text);
            }
        };

        ActionListener listener7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("7");
                text += "7";
                field.setText(text);
            }
        };

        ActionListener listener8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("8");
                text += "8";
                field.setText(text);
            }
        };

        ActionListener listener9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("9");
                text += "9";
                field.setText(text);
            }
        };

        ActionListener listenerCancel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                field.setText("0");
                text = "";
                receiver.cleanArray();
                parser.cleanValueArray();
            }
        };

        ActionListener listenerDiv = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("/");
                text += "/";
                field.setText(text);
            }
        };

        ActionListener listenerMult = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("*");
                text += "*";
                field.setText(text);
            }
        };

        ActionListener listenerPlus = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("+");
                text += "+";
                field.setText(text);
            }
        };

        ActionListener listenerSub = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("-");
                text += "-";
                field.setText(text);
            }
        };

        ActionListener listenerPow = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
                receiver.addValue("^");
                text += "^";
                field.setText(text);
            }
        };
        ActionListener listenerEquals = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!parser.getCorrectInputStatus(receiver.getArray())) {
                    field.setText("Операция недоступна");
                    receiver.cleanArray();
                    parser.cleanValueArray();
                    parser.setTrueStatus();
                } else {
                    parser.parseRequest(receiver.getArray());
                    field.setText("");
                }

                if (comp.computeRequest(parser.getValueArray(), ops) == 0 && ops.getDividedByZeroStatus()){
                    receiver.cleanArray();
                    parser.cleanValueArray();
                    field.setText("Деление на ноль");
                    text = "";
                    ops.setFalseZeroStatus();
                } else {
                    text = "";
                    field.setText(Integer.toString(comp.computeRequest(parser.getValueArray(), ops)));
                    receiver.cleanArray();
                    parser.cleanValueArray();
                }
            }
        };

        btn0.addActionListener(listener0);
        btn1.addActionListener(listener1);
        btn2.addActionListener(listener2);
        btn3.addActionListener(listener3);
        btn4.addActionListener(listener4);
        btn5.addActionListener(listener5);
        btn6.addActionListener(listener6);
        btn7.addActionListener(listener7);
        btn8.addActionListener(listener8);
        btn9.addActionListener(listener9);
        btnCancel.addActionListener(listenerCancel);
        btnSub.addActionListener(listenerSub);
        btnPlus.addActionListener(listenerPlus);
        btnMult.addActionListener(listenerMult);
        btnDiv.addActionListener(listenerDiv);
        btnPow.addActionListener(listenerPow);
        btnEquals.addActionListener(listenerEquals);
        frame.setContentPane(contents1);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI();
            }
        });
    }
}