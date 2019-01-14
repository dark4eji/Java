public class kj {
    public static void main(String[] args) {
        int SIZE = 3;
        char[][] map = {{'X', '*', 'X'},
                        {'*', '*', '*'},
                        {'*', 'O', '*'}};

        char CHAR_DOT = 'X';
        char DOT = '*';

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT){
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }
}