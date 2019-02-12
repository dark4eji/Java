package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static int dimension = 4;
    static int cellSize = 150;
    private char[][] gameField;
    private GameButton[] gameButtons;
    private static boolean isSmarterAI;
    static private int turns = 0;

    private Game game;
    static char nullSymbol = '\u0000';

    public GameBoard(Game currentGame) {
        this.game = currentGame;
        initField();
    }

    public void initField() {
        setBounds(cellSize * dimension, cellSize * dimension, 400, 400);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("Новая игра");
        JCheckBox difficultyBox = new JCheckBox("Усложенный компьютер");
        difficultyBox.setSelected(true);
        setDifficulty(difficultyBox);

        difficultyBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDifficulty(difficultyBox);
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));

        controlPanel.add(newGameButton);
        controlPanel.add(difficultyBox);

        controlPanel.setSize(cellSize * dimension, 150);

        JPanel gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize * dimension, cellSize * dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        for (int i = 0; i < (dimension * dimension); i++) {
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    void emptyField() {
        for (int i = 0; i < (dimension * dimension); i++) {
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol;
        }
    }

    Game getGame() {
        return game;
    }

    void updateGameField(int x, int y) {
        gameField[x][y] = game.getCurrentPlayer().getPlayerSign();
    }

    public GameButton getButton(int buttonIndex) {
        return gameButtons[buttonIndex];
    }

    public char[][] getGameField(){
        return gameField;
    }

    private void setDifficulty(JCheckBox difficultyBox) {
        isSmarterAI = difficultyBox.isSelected();
    }

    public boolean getDifficulty() {
        return isSmarterAI;
    }

    public void setTurns() {
        turns += 1;
    }

    public int getTurns() {
        return turns;
    }
}
