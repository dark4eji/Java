package game;

public class GameStateChecker {

    public GameStateChecker(){

    }

    public boolean checkWin(GameBoard board, int x, int y) {
        boolean result = false;

        int dimension = GameBoard.dimension;
        int[] count = { 0, 0, 0, 0 };

        char[][] gameField = board.getGameField();
        char sign = board.getGame().getCurrentPlayer().getPlayerSign();

        for (int i = 0; i < dimension; i++) {
            count[0] = (gameField[i][i] == sign)
                    ? count[0] + 1 : count[0];
            count[1] = (gameField[i][(gameField[i].length - 1) - i] == sign)
                    ? count[1] + 1 : count[1];
            count[2] = (gameField[x][i] == sign)
                    ? count[2] + 1 : count[2];
            count[3] = (gameField[i][y] == sign)
                    ? count[3] + 1 : count[3];
        }

        result = ( count[0] == dimension || count[1] == dimension
                || count[2] == dimension || count[3] == dimension);

        return result;
    }

    boolean isFull(GameBoard board) {
        boolean result = true;
        char[][] gameField = board.getGameField();

        for (int i = 0; i < GameBoard.dimension; i++) {
            for (int j = 0; j < GameBoard.dimension; j++) {
                if (gameField[i][j] == GameBoard.nullSymbol) {
                    result = false;
                }
            }
        }
        return result;
    }

    boolean isTurnable(GameBoard board, int x, int y) {
        boolean result = false;
        char[][] gameField = board.getGameField();

        if (gameField[x][y] == GameBoard.nullSymbol) {
            result = true;
        }

        return result;
    }
}
