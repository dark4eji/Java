package game;

import javax.swing.*;

public class Game {
    private GameBoard board;
    private GamePlayer[] gamePlayers = new GamePlayer[2];
    private int playersTurn = 0;

    public Game() {
        this.board = new GameBoard(this);
    }

    public void initGame() {
        gamePlayers[0] = new GamePlayer(true, 'O');
        gamePlayers[1] = new GamePlayer(false,'X');
    }

    void passTurn() {
        if (playersTurn == 0) {
            playersTurn = 1;
        } else {
            playersTurn = 0;
        }
    }

    GamePlayer getCurrentPlayer() {
        return gamePlayers[playersTurn];
    }

    void showMessage(String messageText) {
        JOptionPane.showMessageDialog(board, messageText);
    }
}