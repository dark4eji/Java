package game;

import java.util.Random;

public class GameAI {
    private GameStateChecker status = new GameStateChecker();
    private int[] coordinates = new int[2];

    public void updateByAIData(GameBoard board,
                               GameButton button,
                               GameActionListener listener) {
        if (board.getDifficulty()){
            playSmarterAI(board);
        } else {
            playDumbAI(board);
        }

        if (board.getTurns() >= GameBoard.dimension) {
            if (status.checkWin(board, coordinates[0], coordinates[1])) {
                button.getBoard().getGame().showMessage("Компьютер выиграл!");
                board.emptyField();
            } else {
                board.getGame().passTurn();
            }
        } else {
            board.getGame().passTurn();
        }
    }

    private void playDumbAI(GameBoard board) {
        Random rnd = new Random();

        do {
            coordinates[0] = rnd.nextInt(GameBoard.dimension);
            coordinates[1] = rnd.nextInt(GameBoard.dimension);
        } while (!status.isTurnable(board, coordinates[0], coordinates[1]));

        doCellIndex(coordinates[0], coordinates[1], board);
    }

    private void playSmarterAI(GameBoard board) {
        int maxScoreFieldX = -1;
        int maxScoreFieldY = -1;
        int maxScore = 0;

        char sign = board.getGame().getCurrentPlayer().getPlayerSign();

        for (int i = 0; i < GameBoard.dimension; i++) {
            for (int j = 0; j < GameBoard.dimension; j++) {
                int fieldScore = 0;

                if (board.getGameField()[i][j] == GameBoard.nullSymbol) {
                    if (i - 1 >= 0 && j - 1 >= 0 && board.getGameField()[i - 1][j - 1] == sign) {
                        fieldScore++;
                    }

                    if (i + 1 < GameBoard.dimension && j - 1 >= 0 && board.getGameField()[i + 1][j - 1] == sign) {
                        fieldScore++;
                    }

                    if ( i - 1 >= 0 && j + 1 < GameBoard.dimension && board.getGameField()[i - 1][j + 1] == sign) {
                        fieldScore++;
                    }

                    if ( i + 1 < GameBoard.dimension && j + 1 < GameBoard.dimension && board.getGameField()[i + 1][j + 1] == sign ) {
                        fieldScore++;
                    }

                    if ( i - 1 >= 0 && board.getGameField()[i - 1][j] == sign ) {
                        fieldScore++;
                    }

                    if ( j - 1 >= 0 && board.getGameField()[i][j - 1] == sign) {
                        fieldScore++;
                    }

                    if ( j + 1 < GameBoard.dimension && board.getGameField()[i][j + 1] == sign ) {
                        fieldScore++;
                    }

                    if ( i + 1 < GameBoard.dimension && board.getGameField()[i + 1][j] == sign ) {
                        fieldScore++;
                    }
                }

                if (fieldScore > maxScore) {
                    maxScore = fieldScore;
                    maxScoreFieldX = i;
                    maxScoreFieldY = j;
                }
            }
        }

        if (maxScoreFieldX != -1) {
            coordinates[0] = maxScoreFieldX;
            coordinates[1] = maxScoreFieldY;
            doCellIndex(coordinates[0], coordinates[1], board);
        } else {
            playDumbAI(board);
        }
    }

    private void doCellIndex(int x, int y, GameBoard board) {
        board.setTurns();
        board.updateGameField(x, y);
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
        if (status.isFull(board)) {
            board.getGame().showMessage("Ничья!");
            board.emptyField();
        }
    }
}
