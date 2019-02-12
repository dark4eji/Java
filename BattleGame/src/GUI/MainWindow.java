package GUI;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        JFrame mainWindow = new JFrame("Demo");
        JPanel mainPanel = new JPanel();

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1000, 800);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);

        JButton createChar = new JButton();
        JButton exit = new JButton();

        mainPanel.add(createChar, CENTER_ALIGNMENT);
        mainPanel.add(exit, CENTER_ALIGNMENT);

        mainWindow.setContentPane(mainPanel);
    }

}
