package game;

public class GameHumanTurn {
    private GameStateChecker status = new GameStateChecker();

    public void makePlayerTurn(GameBoard board,
                         GameButton button,
                         GameActionListener listener) {
        GameHumanTurn player = new GameHumanTurn();
        GameAI AI = new GameAI();
        GameStateChecker status = new GameStateChecker();

        if (status.isTurnable(board, listener.getRow(), listener.getCell())) {
            board.updateGameField(listener.getRow(), listener.getCell());
            updateByPlayersData(board, button, listener);

            if (status.isFull(board)) {
                board.getGame().showMessage("Ничья!");
                board.emptyField();
            } else {
                AI.updateByAIData(board, button, listener);
            }

        } else {
            board.getGame().showMessage("Некорректный ход!");
        }
    }
    private void updateByPlayersData(GameBoard board,
                                    GameButton button,
                                    GameActionListener listener) {
        board.setTurns();
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.getTurns() >= GameBoard.dimension) {
            if (status.checkWin(board, listener.getRow(), listener.getCell())) {
                button.getBoard().getGame().showMessage("Вы выиграли");
                board.emptyField();

            } else {
                board.getGame().passTurn();
            }
        } else {
            board.getGame().passTurn();
        }
    }
}

