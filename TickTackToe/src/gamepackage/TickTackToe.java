package gamepackage;

public class TickTackToe {
    private static char map[][] = {{'X', '*', '*', 'X'},
                                   {'*', 'X', 'X', '*'},
                                   {'X', 'X', '*', 'X'},
                                   {'X', 'X', '*', '*'}};
    private static int SIZE = 4;

    public static void main(String[] args) {
        System.out.println(checkWin());
    }

    public static boolean checkWin(){
        boolean result = false;
        int[] count = {0, 0, 0, 0};

        for ( int i = 0; i < SIZE; i++ ) {
            count[0] = ( map[i][i] == 'X' ) ? count[0] + 1 : count[0];
            count[1] = ( map[i][(map[i].length - 1) - i] == 'X' ) ? count[1] + 1 : count[1];

            for ( int j = 0; j < SIZE; j++ ) {
                count[2] = ( map[i][j] == 'X' ) ? count[2] + 1 : count[2];
                count[3] = ( map[j][i] == 'X' ) ? count[3] + 1 : count[3];
            }

            if (count[0] == SIZE || count[1] == SIZE || count[2] == SIZE || count[3] == SIZE) {
                result = true;
                break;
            } else {
                count[3] = count[2] = 0;
            }
        }
        return result;
    }
}
