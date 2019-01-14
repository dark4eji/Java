package gamepackage;

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    private static char[][] map;
    private static char HUMAN_CHAR = 'X';
    private static char COMP_CHAR = 'O';
    private static char DOT_EMPTY = '•';

    private static int SIZE = 4;
    private static int turn_count = 0;

    private static boolean win_state = false;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main( String[] args ) {
        initMap();
        printMap();

        while(true) {

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            humanTurn();
            if (win_state) {
                System.out.println("Победил человек");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            computerTurn();
            if (win_state) {
                System.out.println("Победил компьютер");
                break;
            }
        }
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
    public static void humanTurn() {
        int x, y;

        do {
            System.out.print( "Введите координаты через пробел: " );
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while ( !isCellValid(x, y) );

        addCheckChar( HUMAN_CHAR, x, y );
    }
//-----------------------------------------------------------------------------------
    private static void computerTurn() {
        int x, y;

        do {
            x = random.nextInt( SIZE );
            y = random.nextInt( SIZE );
        } while ( !isCellValid(x, y) );

        System.out.println("Компьютер выбрал ячейку " + ( y + 1 ) + " " + ( x + 1 ));

        addCheckChar( COMP_CHAR, x, y );
    }
//-----------------------------------------------------------------------------------
    private static void aiEvaluator(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){

            }
        }

    }
//-----------------------------------------------------------------------------------
    private static void addCheckChar( char playerChar, int x, int y ) {
        turn_count += 1;
        map[x][y] = playerChar;

        printMap();

        if ( turn_count >= SIZE ) {
            checkWin(playerChar, x, y);
        }
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
        boolean result = false;
        int freeCells = SIZE * SIZE;
        for ( int i = 0; i < SIZE; i++ ) {
            for ( int j = 0; j < SIZE; j++ ) {
                freeCells = ( map[i][j] != DOT_EMPTY ) ? freeCells - 1 : freeCells;
            }
        }
        result = ( freeCells == 0 );
        return result;
    }
//-----------------------------------------------------------------------------------
    private static void checkWin( char playerSymbol, int x, int y ) {
        /** Метод выполняет проверку ходов на выигрыш/отсутствие условия выигрыша как человка, так и компьютера */
        int[] count = { 0, 0, 0, 0 };

        for ( int i = 0; i < SIZE; i++ ) {
            count[0] = ( map[i][i] == playerSymbol ) ? count[0] + 1 : count[0];
            count[1] = ( map[i][(map[i].length - 1 ) - i] == playerSymbol) ? count[1] + 1 : count[1];
            count[2] = ( map[x][i] == playerSymbol ) ? count[2] + 1 : count[2];
            count[3] = ( map[i][y] == playerSymbol ) ? count[3] + 1 : count[3];
        }

        win_state = ( count[0] == SIZE || count[1] == SIZE || count[2] == SIZE || count[3] == SIZE );
    }
}