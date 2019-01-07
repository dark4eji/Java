package gamepackage;

import java.util.Scanner;

public class TickTackToe {

    private static char[][] map;
    private static int SIZE = 3;
    private static char PLAYER_CHAR = 'X';
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
            int checker = 0;
            boolean result = false;
            Scanner scanner = new Scanner(System.in);

            while (!result) {
                printMap(SIZE);

                System.out.print("Enter X: ");
                int x = scanner.nextInt();

                System.out.print("Enter Y: ");
                int y = scanner.nextInt();

                map[x][y] = 'X';

                checker += 1;
                if (checker >= SIZE) {
                    result = checkWin();
                    System.out.println(result);
                }
            }
            if (result) {
                printMap(SIZE);
                System.out.println("Win");
            }
        }

        public static boolean checkWin() {
        /** Метод выполняет проверку ходов на выигрыш/отсутствие условия выигрыша как человка, так и компьютера */
            boolean result = false;
            int[] count = { 0, 0, 0, 0 };  //Содержит количество совпадений с символами игрока-человека

            for ( int i = 0; i < SIZE; i++ ) {
                count[0] = ( map[i][i] != PLAYER_CHAR ) ? count[0] : count[0] + 1;
                count[1] = ( map[i][( map[i].length - 1 ) - i] != PLAYER_CHAR ) ? count[1] : count[1] + 1;

                for ( int j = 0; j < SIZE; j++ ) {
                    count[2] = ( map[i][j] != PLAYER_CHAR ) ? count[2] : count[2] + 1;
                    count[3] = ( map[j][i] != PLAYER_CHAR ) ? count[3] : count[3] + 1;
                }

                if (count[0] == SIZE || count[1] == SIZE || count[2] == SIZE || count[3] == SIZE) {
                    result = true;
                } else {
                    count[2] = count[3] = 0;
                }
            }
            return result;
        }
    }