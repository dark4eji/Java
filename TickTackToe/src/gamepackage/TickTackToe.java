package gamepackage;

import java.util.Scanner;

public class TickTackToe {

    private static char[][] map;
    private static int SIZE = 3;
    private static char PLAYER_CHAR = 'X';
    private static char COMP_CHAR = 'O';
    public static void main(String[] args) {
        initMap(SIZE);
        gamingMet();

    }

    public static void initMap (int SIZE){
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = '*';
            }
        }
    }

    public static void printMap(int SIZE) {
        for (int b = 0; b < SIZE; b++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[b][j] + " ");
            }
            System.out.println();
        }
    }

    public static void gamingMet() {
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        int checker = 0;

        while (!result) {
            printMap(SIZE);

            System.out.print("Enter X: ");
            int x = scanner.nextInt();

            System.out.print("Enter Y: ");
            int y = scanner.nextInt();

            map[x][y] = PLAYER_CHAR;

            checker += 1;
            result = (checker >= SIZE) ? checkWin(PLAYER_CHAR) : result;
            }

        if (checkWin(PLAYER_CHAR)) {
            printMap(SIZE);
            System.out.println("Win");
        } else {
            printMap(SIZE);
            System.out.println("Lose");
        }
    }

    public static boolean checkWin(char turn_char) {
        /** Метод выполняет проверку ходов на выигрыш/отсутствие условия выигрыша как человка, так и компьютера */
        boolean result = false;
        int[] count = { 0, 0, 0, 0 };

        for ( int i = 0; i < SIZE; i++ ) {
            //Считывает символы по диагонали сверху вниз слева направо
            count[0] = ( map[i][i] == turn_char ) ? count[0] + 1 : count[0];
            //Считывает символы по диагонали сверху вниз справа налево
            count[1] = ( map[i][( map[i].length - 1 ) - i] == turn_char ) ? count[1] + 1 : count[1];

            for ( int j = 0; j < SIZE; j++ ) {
                //Считывает символы в столбцах сверху вниз (SIZE столбцов)
                count[2] = ( map[i][j] == turn_char ) ? count[2] + 1 : count[2];
                //Считывает символы в строках справа налево (SIZE строк)
                count[3] = ( map[j][i] == turn_char ) ? count[3] + 1 : count[3];
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