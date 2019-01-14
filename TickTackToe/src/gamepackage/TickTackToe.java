package gamepackage;

import java.util.Scanner;
import java.util.Random;

public class TickTackToe {

    private static char[][] map;
    private static int SIZE = 3;
    private static char PLAYER_CHAR = 'X';
    private static char COMP_CHAR = 'O';
    private static char DOT_EMPTY = '•';

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();

        while(true) {
            humanTurn();
            if (isEndGame(PLAYER_CHAR)) {
                break;
            }

            computerTurn();
            if (isEndGame(COMP_CHAR)) {
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void humanTurn() {
        int x, y;

        do {
            System.out.print("Введите координаты через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = PLAYER_CHAR;
        printMap();

    }
    private static void computerTurn() {
        int x, y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while(!isCellValid(x, y));

        System.out.println("Компьютер выбрал ячейку " + ( y + 1 ) + " " + ( x + 1 ));
        map[x][y] = COMP_CHAR;
        printMap();
    }

    private static boolean isCellValid(int x, int y) {
        boolean result = true;

        if (x < 0 || x >= SIZE || y < 0 || y >=SIZE) {
            result = false;
        }

        if (map[x][y] != DOT_EMPTY) {
            result = false;
        }

        return result;
    }

    private static boolean isEndGame(char playerSymbol) {
       boolean result = false;

       if (checkWin(playerSymbol)){
           System.out.println("Победили " + playerSymbol);
           result = true;
       }

       if (isMapFull()) {
           System.out.println("Ничья");
           result = true;
       }

       return result;
    }

    private static boolean isMapFull() {
        boolean result = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result = (map[i][j] == DOT_EMPTY) ? false : result;
            }
        }

        return result;
    }

    public static boolean checkWin(char playerSymbol) {
        /** Метод выполняет проверку ходов на выигрыш/отсутствие условия выигрыша как человка, так и компьютера */
        boolean result = false;
        int[] count = { 0, 0, 0, 0 };

        for ( int i = 0; i < SIZE; i++ ) {
            count[0] = ( map[i][i] == playerSymbol ) ? count[0] + 1 : count[0];
            count[1] = ( map[i][( map[i].length - 1 ) - i] == playerSymbol ) ? count[1] + 1 : count[1];

            for ( int j = 0; j < SIZE; j++ ) {
                count[2] = ( map[i][j] == playerSymbol ) ? count[2] + 1 : count[2];
                count[3] = ( map[j][i] == playerSymbol ) ? count[3] + 1 : count[3];
            }
            if ( count[0] == SIZE || count[1] == SIZE || count[2] == SIZE || count[3] == SIZE ) {
                result = true;
            } else {
                count[2] = count[3] = 0;
            }
        }
        return result;
    }
}