package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;

    public GameActionListener(int row, int cell, GameButton gButton) {
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();
        GameHumanTurn player = new GameHumanTurn();
        player.makePlayerTurn(board, button, GameActionListener.this);
    }

    public int getRow(){
        return row;
    }

    public int getCell(){
        return cell;
    }
}
