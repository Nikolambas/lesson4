import java.util.Random;
import java.util.Scanner;

public class Main {
//    прописать умный интелект
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int SIZE = 3;
    private static final char MAIN_SYMBOL_X = 'X';
    private static final char MAIN_SYMBOL_O = '0';
    private static final char MAIN_SYMBOL = '_';
    private static final char[][] field = new char[SIZE][SIZE];

    public static void main(String[] args) {
        initializeField(field);
        while (true){
            printField(field);
            playerTurn(field);
            if (isGameOver(field)==false){
                printField(field);
                break;
            }
            compTurn(field);
            if (isGameOver(field)==false){
                printField(field);
                break;
            }
        }
    }

    public static void initializeField(char[][] fi) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                fi[i][j] = MAIN_SYMBOL;
            }
        }
    }

    public static void playerTurn(char[][] f) {
        int x, y;
        boolean bo = true;
        do {
            System.out.println("Ваш ход, введите значение.");
            x = scanner.nextInt()-1;
            y = scanner.nextInt()-1;
            if (0 <= x && x < f.length && 0 <= y && y < f.length
                    && f[x][y]!=MAIN_SYMBOL_O && f[x][y]!=MAIN_SYMBOL_X) {
                f[x][y] = MAIN_SYMBOL_X;
                bo = false;
            }
        }
        while (bo);

    }

    public static void compTurn(char[][] f) {
        for (int i = 0; i < f.length; i++) {
            char[]chars=new char[3];
            for (int j = 0; j < f.length; j++) {
                chars[j]=f[i][j];
            }if (chars[0]==chars[1]&&chars[0]==MAIN_SYMBOL_X&&chars[2]==MAIN_SYMBOL){
                f[i][2]=MAIN_SYMBOL_O;
                return;
            }if (chars[0]==chars[2]&&chars[0]==MAIN_SYMBOL_X&&chars[1]==MAIN_SYMBOL){
                f[i][1]=MAIN_SYMBOL_O;
                return;
            }if (chars[2]==chars[1]&&chars[1]==MAIN_SYMBOL_X&&chars[0]==MAIN_SYMBOL){
                f[i][0]=MAIN_SYMBOL_O;
                return;
            }
        }
        for (int i = 0; i < f.length; i++) {
            char[]chars=new char[3];
            for (int j = 0; j < f.length; j++) {
                chars[j]=f[j][i];
            }if (chars[0]==chars[1]&&chars[0]==MAIN_SYMBOL_X&&chars[2]==MAIN_SYMBOL){
                f[2][i]=MAIN_SYMBOL_O;
                return;
            }if (chars[0]==chars[2]&&chars[0]==MAIN_SYMBOL_X&&chars[1]==MAIN_SYMBOL){
                f[1][i]=MAIN_SYMBOL_O;
                return;
            }if (chars[2]==chars[1]&&chars[1]==MAIN_SYMBOL_X&&chars[0]==MAIN_SYMBOL){
                f[0][i]=MAIN_SYMBOL_O;
                return;
            }
        }
        char[]chars=new char[3];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                if (i==j){
                    chars[i]=f[i][j];
                }
            }
        }if (chars[0]==chars[1]&&chars[0]==MAIN_SYMBOL_X&&chars[2]==MAIN_SYMBOL){
            f[2][2]=MAIN_SYMBOL_O;
            return;
        }if (chars[0]==chars[2]&&chars[0]==MAIN_SYMBOL_X&&chars[1]==MAIN_SYMBOL){
            f[1][1]=MAIN_SYMBOL_O;
            return;
        }if (chars[2]==chars[1]&&chars[1]==MAIN_SYMBOL_X&&chars[0]==MAIN_SYMBOL){
            f[0][0]=MAIN_SYMBOL_O;
            return;
        }
        for (int i = 0; i < f.length; i++) {
            for (int j = 2; j >=0 ; j--) {
                if (i+j==f.length-1){
                    chars[i]=f[i][j];
                }
            }
        }if (chars[0]==chars[1]&&chars[0]==MAIN_SYMBOL_X&&chars[2]==MAIN_SYMBOL){
            f[2][0]=MAIN_SYMBOL_O;
            return;
        }if (chars[0]==chars[2]&&chars[0]==MAIN_SYMBOL_X&&chars[1]==MAIN_SYMBOL){
            f[1][1]=MAIN_SYMBOL_O;
            return;
        }if (chars[2]==chars[1]&&chars[1]==MAIN_SYMBOL_X&&chars[0]==MAIN_SYMBOL){
            f[0][2]=MAIN_SYMBOL_O;
            return;
        }
        boolean bo = true;
        while (bo) {
            int x=random.nextInt(SIZE);
            int y=random.nextInt(SIZE);
            if (f[x][y]!=MAIN_SYMBOL_O&&f[x][y]!=MAIN_SYMBOL_X) {
                f[x][y] = MAIN_SYMBOL_O;
                bo = false;
            }
        }
    }

    public static void printField(char[][] f) {
        System.out.print("  ");
        for (int i = 0; i < f.length; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < f.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < f[0].length; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static boolean isGameOver(char[][] f) {
        for (int i = 0; i < f.length; i++) {
            int countO=0;
            int countX=0;
            for (int j = 0; j < f[i].length; j++) {
                if (f[i][j] == MAIN_SYMBOL_X) {
                    countX++;
                }
                if (f[i][j] == MAIN_SYMBOL_O) {
                    countO++;
                }
            }
            if (countO == SIZE || countX == SIZE) {
                System.out.println("Игра окончена");
                return false;
            }
        }
        for (int i = 0; i < f.length; i++) {
            int countO=0;
            int countX=0;
            for (int j = 0; j < f[i].length; j++) {
                if (f[j][i] == MAIN_SYMBOL_X) {
                    countX++;
                }
                if (f[j][i] == MAIN_SYMBOL_O) {
                    countO++;
                }
            }
            if (countO == SIZE || countX == SIZE) {
                System.out.println("Игра окончена");
                return false;
            }
        }
        int countO=0;
        int countX=0;
        for (int i = 0; i < f.length; i++) {
            for (int j = f.length-1; 0 <= j; j--) {
                if (i+j==SIZE-1&&f[i][j] == MAIN_SYMBOL_X) {
                    countX++;
                }
                if (i+j==SIZE-1&&f[i][j] == MAIN_SYMBOL_O) {
                    countO++;
                }
            }
        }
        if (countO==SIZE||countX==SIZE){
            System.out.println("Игра окончена");
            return false;
        }
        countO=0;
        countX=0;
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                if (i==j&&f[i][j]==MAIN_SYMBOL_X){
                    countX++;
                }
                if (i==j&&f[i][j]==MAIN_SYMBOL_O){
                    countO++;
                }
            }
        }
        if (countO==SIZE||countX==SIZE){
            System.out.println("Игра окончена");
            return false;
        }
        int count_=0;
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {
                if (f[i][j]==MAIN_SYMBOL){
                    count_++;
                }
            }
        }
        if (count_==0){
            System.out.println("Ничья");
            return false;
        }
      return true;
    }

    public static boolean isGameOverField5x5(char[][] f) {
        for (int i = 0; i < 5; i++) {
            int countX = 0;
            int count0 = 0;
            for (int j = 0; j < 5; j++) {
                if (f[i][j] == MAIN_SYMBOL_X) {
                    countX++;
                }
                if (f[i][j] == MAIN_SYMBOL_O) {
                    count0++;
                }
            }
            if (count0 == 4&&f[i][0]!=f[i][4] || countX == 4&&f[i][0]!=f[i][4]||count0==5||countX==5) {
                System.out.println("Игра окончена");
                return false;
            }
        }
        for (int i = 0; i < 5; i++) {
            int countX = 0;
            int count0 = 0;
            for (int j = 0; j < 5; j++) {
                if (f[j][i] == MAIN_SYMBOL_X) {
                    countX++;
                }
                if (f[j][i] == MAIN_SYMBOL_O) {
                    count0++;
                }
            }
            if (count0 == 4&&f[i][0]!=f[i][4] || countX == 4&&f[i][0]!=f[i][4]||count0==5||countX==5) {
                System.out.println("Игра окончена");
                return false;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (f[i][j]==MAIN_SYMBOL_O||f[i][j]==MAIN_SYMBOL_X){
                    int count0=0;
                    int countX=0;
                    for (int k = 0; k < 3; k++) {
                        i++;
                        j++;
                        if (f[i][j]==MAIN_SYMBOL_O){
                            count0++;
                        }
                        if (f[i][j]==MAIN_SYMBOL_X){
                            countX++;
                        }
                    }
                    if (count0==3||countX==3){
                        System.out.println("Игра окончена");
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 3; j < 5; j++) {
                if (f[i][j]==MAIN_SYMBOL_O||f[i][j]==MAIN_SYMBOL_X) {
                    int count0 = 0;
                    int countX = 0;
                    for (int k = 0; k < 3; k++) {
                        i++;
                        j--;
                        if (f[i][j] == MAIN_SYMBOL_O) {
                            count0++;
                        }
                        if (f[i][j] == MAIN_SYMBOL_X) {
                            countX++;
                        }
                    }
                    if (count0 == 3 || countX == 3) {
                        System.out.println("Игра окончена");
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
