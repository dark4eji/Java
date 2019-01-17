package gamepackage;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    private static char[][] map;
    private static char HUMAN_CHAR = 'X';
    private static char COMP_CHAR = 'O';
    private static char DOT_EMPTY = '•';

    private static final int SIZE = 3;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main( String[] args ) {
        int[] coordinatesBuffer = new int[2];  // Хранит координаты точки: x = [0], y = [1]
        int turnsCounter = 0;

        initMap();
        printMap();

        while(true) {
            turnsCounter++;

            humanTurn(coordinatesBuffer);
            if ( turnsCounter >= SIZE ) {
                if ( isEndGame(HUMAN_CHAR, coordinatesBuffer) ) {
                    break;
                }
            }

            computerTurn(coordinatesBuffer);
            if ( turnsCounter >= SIZE ) {
                if ( isEndGame(COMP_CHAR, coordinatesBuffer) ) {
                    break;
                }
            }
        }

        System.out.println("Игра закончена");
    }
//-----------------------------------------------------------------------------------
    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
//-----------------------------------------------------------------------------------
    public static void printMap() {
        for ( int i = 0; i <= SIZE; i++ ){
            System.out.print( i + " " );
        }

        System.out.println();

        for ( int i = 0; i < SIZE; i++ ) {
            System.out.print( (i + 1) + " " );
            for ( int j = 0; j < SIZE; j++ ) {
                System.out.print( map[i][j] + " " );
            }
            System.out.println();
        }

        System.out.println();
    }
//-----------------------------------------------------------------------------------
    public static void humanTurn(int[] coordinatesBuffer) {
        do {
            System.out.print( "Введите координаты через пробел: " );
            coordinatesBuffer[0] = scanner.nextInt() - 1;
            coordinatesBuffer[1] = scanner.nextInt() - 1;
        } while ( !isCellValid ( coordinatesBuffer[0], coordinatesBuffer[1] ));

        setsDataAndPrintMap(HUMAN_CHAR, coordinatesBuffer);
    }
//-----------------------------------------------------------------------------------
    private static void computerTurn( int[] coordinatesBuffer ) {
        int maxScoreFieldX = -1;
        int maxScoreFieldY = -1;
        int maxScore = 0;

        for ( int i = 0; i < SIZE; i++ ) {
            for ( int j = 0; j < SIZE; j++ ) {
                int fieldScore = 0;

                if ( map[i][j] == DOT_EMPTY ) {

                    if ( i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] == COMP_CHAR ) {
                        fieldScore++;
                    }

                    if ( i + 1 < SIZE && j - 1 >= 0 && map[i + 1][j - 1] == COMP_CHAR ) {
                        fieldScore++;
                    }

                    if ( i - 1 >= 0 && j + 1 < SIZE && map[i - 1][j + 1] == COMP_CHAR ) {
                        fieldScore++;
                    }

                    if ( i + 1 < SIZE && j + 1 < SIZE && map[i + 1][j + 1] == COMP_CHAR ) {
                        fieldScore++;
                    }

                    if ( i - 1 >= 0 && map[i - 1][j] == COMP_CHAR ) {
                        fieldScore++;
                    }

                    if ( j - 1 >= 0 && map[i][j - 1] == COMP_CHAR) {
                        fieldScore++;
                    }

                    if ( j + 1 < SIZE && map[i][j + 1] == COMP_CHAR ) {
                        fieldScore++;
                    }

                    if ( i + 1 < SIZE && map[i + 1][j] == COMP_CHAR ) {
                        fieldScore++;
                    }
                }

                if ( fieldScore > maxScore ) {
                    maxScore = fieldScore;
                    maxScoreFieldX = i;
                    maxScoreFieldY = j;
                }
            }
        }

        if ( maxScoreFieldX != -1 ) {
            coordinatesBuffer[0] = maxScoreFieldX;
            coordinatesBuffer[1] = maxScoreFieldY;
        }

        if ( maxScoreFieldX == -1 ) {
            System.out.println("kek");
            do {
                coordinatesBuffer[0] = random.nextInt(SIZE);
                coordinatesBuffer[1] = random.nextInt(SIZE);
            } while (!isCellValid(coordinatesBuffer[0], coordinatesBuffer[1]));
        }

        map[coordinatesBuffer[0]][coordinatesBuffer[1]] = COMP_CHAR;

        printMap();

        System.out.println("Компьютер выбрал ячейку " + ( coordinatesBuffer[0] + 1 )
                + " " + ( coordinatesBuffer[1] + 1 ));
    }
//-----------------------------------------------------------------------------------
    private static void setsDataAndPrintMap( char playerChar,
                                           int[] coordinatesBuffer ) {
        map[coordinatesBuffer[0]][coordinatesBuffer[1]] = playerChar;

        printMap();
    }
// ----------------------------------------------------------------------------------
    private static boolean isEndGame( char playerSymbol,
                                      int[] coordinatesBuffer ){
        boolean result = false;

        if ( checkWin(playerSymbol, coordinatesBuffer) ) {
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        if (result) {
            return result;
        }

        if (isMapFull()) {
            System.out.println("Ничья");
        }

        return result;
    }
//-----------------------------------------------------------------------------------
    private static boolean isCellValid( int x, int y ) {
        boolean result = true;

        if ( x < 0 || x >= SIZE || y < 0 || y >=SIZE ) {
            result = false;
            return result;
        }

        if ( map[x][y] != DOT_EMPTY ) {
            result = false;
        }

        return result;
    }
//-----------------------------------------------------------------------------------
    private static boolean isMapFull() {
        boolean result = true;

        for ( int i = 0; i < SIZE; i++ ) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }

        return result;
    }
//-----------------------------------------------------------------------------------
    private static boolean checkWin( char playerSymbol, int[] coordinatesBuffer ) {
        /** Метод выполняет проверку ходов на выигрыш/отсутствие условия выигрыша как человка, так и компьютера */
        boolean result = false;
        int[] count = { 0, 0, 0, 0 };

        for ( int i = 0; i < SIZE; i++ ) {
            count[0] = ( map[i][i] == playerSymbol ) ? count[0] + 1 : count[0];
            count[1] = ( map[i][(map[i].length - 1 ) - i] == playerSymbol) ? count[1] + 1 : count[1];
            count[2] = ( map[coordinatesBuffer[0]][i] == playerSymbol ) ? count[2] + 1 : count[2];
            count[3] = ( map[i][coordinatesBuffer[1]] == playerSymbol ) ? count[3] + 1 : count[3];
        }

        result = ( count[0] == SIZE || count[1] == SIZE || count[2] == SIZE || count[3] == SIZE );
        return result;
    }
}