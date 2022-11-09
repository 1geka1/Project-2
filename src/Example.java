import java.util.Scanner;

public class Example {
    static Scanner in = new Scanner(System.in);
    static final int columnsAndRows = 3;
    static boolean won = false;
    static int[][] arrTable = new int[columnsAndRows][columnsAndRows];
    static String[][] table = new String[columnsAndRows][columnsAndRows];


    public static void easyBotMove(String [][] table, int [][] arrTable){
        int i,j;
        do {
            i = (int) (Math.random() * 3);
            j = (int) (Math.random() * 3);
        } while (table[i][j] == "O" || table[i][j] == "X");
        table[i][j] = "O";
        arrTable[i][j] = 2;
        System.out.println("Making move level \"easy\" ");
        getTable(table);
    }

    public static void victoryCheck(String[][] table, int [][] arrTable){
        if (table[0][0].equals(table[0][1]) & table[0][1].equals(table[0][2]) & table[0][0].equals("X")) {
            won = true;
            System.out.println("\t" + "X wins");

        } else if (table[0][0].equals(table[0][1]) && table[0][1].equals(table[0][2]) && table[0][0].equals("O")) {
            won = true;
            System.out.println("\t" + "O wins");

        } else if (table[1][0].equals(table[1][1]) && table[1][1].equals(table[1][2]) && table[1][0].equals("X")) {
            won = true;
            System.out.println("\t" + "X wins");

        } else if (table[1][0].equals(table[1][1]) && table[1][1].equals(table[1][2]) && table[1][0].equals("O")) {
            won = true;
            System.out.println("\t" + "O wins");

        } else if (table[2][0].equals(table[2][1]) && table[2][1].equals(table[2][2]) && table[2][0].equals("X")) {
            won = true;
            System.out.println("\t" + "X wins");

        } else if (table[2][0].equals(table[2][1]) && table[2][1].equals(table[2][2]) && table[2][0].equals("O")) {
            won = true;
            System.out.println("\t" + "O wins");

        } else if (table[0][0].equals(table[1][0]) && table[1][0].equals(table[2][0]) && table[0][0].equals("X")) {
            won = true;
            System.out.println("\t" + "X wins");

        } else if (table[0][0].equals(table[1][0]) && table[1][0].equals(table[2][0]) && table[0][0].equals("O")) {
            won = true;
            System.out.println("\t" + "O wins");

        } else if (table[0][1].equals(table[1][1]) && table[1][1].equals(table[2][1]) && table[0][1].equals("X")) {
            won = true;
            System.out.println("\t" + "X wins");

        } else if (table[0][1].equals(table[1][1]) && table[1][1].equals(table[2][1]) && table[0][1].equals("O")) {
            won = true;
            System.out.println("\t" + "O wins");

        } else if (table[0][2].equals(table[1][2]) && table[1][2].equals(table[2][2]) && table[0][2].equals("X")) {
            won = true;
            System.out.println("\t" + "X wins");

        } else if (table[0][2].equals(table[1][2]) && table[1][2].equals(table[2][2]) && table[0][2].equals("O")) {
            won = true;
            System.out.println("\t" + "O wins");

        } else if (table[0][0].equals(table[1][1]) && table[1][1].equals(table[2][2]) && table[0][0].equals("X")) {
            won = true;
            System.out.println("\t" + "X wins");

        } else if (table[0][0].equals(table[1][1]) && table[1][1].equals(table[2][2]) && table[0][0].equals("O")) {
            won = true;
            System.out.println("\t" + "O wins");

        } else if (table[0][2].equals(table[1][1]) && table[1][1].equals(table[2][0]) && table[0][2].equals("X")) {
            won = true;
            System.out.println("\t" + "X wins");

        } else if (table[0][2].equals(table[1][1]) && table[1][1].equals(table[2][0]) && table[0][2].equals("O")) {
            won = true;
            System.out.println("\t" + "O wins");
        } else if (draw(arrTable) && !won) {
            won = true;
            System.out.println("\t" + "Draw");
        } else won = false;
        if (won == false)
            System.out.println("Game not finished");
    }
    public static char[][] convert1DTo2D(char[] fieldInput) {

        int rows = fieldInput.length / columnsAndRows;
        double size = (double) fieldInput.length / (double) columnsAndRows;
        if (size % 2 != 0) {
            rows += 1;
        }
        char[][] convert = new char[rows][];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            convert[i] = (i + 1 < rows) ? new char[columnsAndRows] : new char[fieldInput.length % columnsAndRows];
            for (int j = 0; j < columnsAndRows; j++) {
                if (count == fieldInput.length) break;
                convert[i][j] = fieldInput[count];
                count++;
            }
        }
        return convert;
    }
    public static boolean draw(int[][] arrTable){
        int draw = 0;
        for (int i = 0; i < columnsAndRows;i++){
            for (int j = 0; j < columnsAndRows;j++){
                if (arrTable[i][j] != 0){
                    draw ++;
                }
            }
        }return draw == 9;
    }

    public static boolean turnOrder(int[][] arrTable) {
        int keyX = 0;
        int keyO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arrTable[i][j] != 0){
                    if (arrTable[i][j] == 1) {
                        keyX++;
                    } else if (arrTable[i][j] > 1) {
                        keyO++;
                    }
                }
            }
        }return keyX <= keyO;
    }
    public static char[][] fillingTables(){
        char[] fieldInput;
        while (true) {
            System.out.print("Enter the cells: ");
            String cells = in.nextLine();
            if (cells.isEmpty()) {
                System.out.println("String is empty");
            }
            fieldInput = cells.toCharArray();
            if (fieldInput.length == 9) {
                System.out.println("\t" + "---------");
                for (int i = 0, n = 0; i < fieldInput.length; i++, n++) {
                    if (n == 3) {
                        System.out.println();
                        n = 0;
                    }
                    System.out.print("\t" + fieldInput[i]);
                }
                System.out.println();
                System.out.println("\t" + "---------");
                break;
            } else System.out.println("Введите 9 символов");
        }

        char[][] fieldInputConvert = convert1DTo2D(fieldInput);
        return fieldInputConvert;
    }

    public static void tableRefill(char[][] fieldInputConvert){
        for (int i = 0; i < columnsAndRows; i++) {
            for (int j = 0; j < columnsAndRows; j++) {
                if (fieldInputConvert[i][j] == '_') {
                    table[i][j] = "_";
                    arrTable[i][j] = 0;
                } else if (fieldInputConvert[i][j] == 'X') {
                    table[i][j] = "X";
                    arrTable[i][j] = 1;
                } else if (fieldInputConvert[i][j] == 'O') {
                    table[i][j] = "O";
                    arrTable[i][j] = 2;
                }
            }
        }
    }

    public static void getTable(String[][] table){
        System.out.println("\t" + "---------");
        System.out.print("\t" + "| " + table[0][0] + " " + table[0][1] + " " + table[0][2] + " |");
        System.out.println();
        System.out.print("\t" + "| " + table[1][0] + " " + table[1][1] + " " + table[1][2] + " |");
        System.out.println();
        System.out.print("\t" + "| " + table[2][0] + " " + table[2][1] + " " + table[2][2] + " |");
        System.out.println();
        System.out.println("\t" + "---------");
    }
    public static void main(String[] args) {
        char[][] fieldInputConvert = fillingTables();
        tableRefill(fieldInputConvert);
        while (true) {
            if (!won) {
                while (true) {
                    System.out.print("Enter the coordinates: ");
                    if (in.hasNextInt()) {
                        int first = in.nextInt();
                        int second = in.nextInt();
                        if (first > 3 || first <= 0) {
                            System.out.println("Coordinates should be from 1 to 3!");
                        } else if (second > 3 || second <= 0) {
                            System.out.println("Coordinates should be from 1 to 3!");
                        } else {
                            if (arrTable[first - 1][second - 1] == 1 || arrTable[first - 1][second - 1] == 2) {
                                System.out.println("This cell is occupied! Choose another one!");
                            } else if (turnOrder(arrTable)) {
                                table[first - 1][second - 1] = "X";
                                arrTable[first - 1][second - 1] = 1;
                                break;
                            } else {
                                table[first - 1][second - 1] = "O";
                                arrTable[first - 1][second - 1] = 2;
                                break;
                            }
                        }
                    } else if (in.hasNextLine()) {
                        String costil = in.nextLine();
                        System.out.println("You should enter numbers!");
                    }
                }

                getTable(table);
                easyBotMove(table,arrTable);
                victoryCheck(table,arrTable);

            }else {
                System.out.println();
                break;
            }
        }
    }
}
