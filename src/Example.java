import java.util.Scanner;

public class Example {
    static Scanner in = new Scanner(System.in);
    static final int columnsAndRows = 3;
    static boolean won = false;
    static int[][] arrTable = new int[columnsAndRows][columnsAndRows];
    static String[][] table = new String[columnsAndRows][columnsAndRows];

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
        if (!won)
            System.out.println("Game not finished");
    }
    public static void playerMove(){
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
    }

    public static void easyBotMove(){
        int i,j;
        do {
            i = (int) (Math.random() * 3);
            j = (int) (Math.random() * 3);
        } while (table[i][j].equals("O") || table[i][j].equals("X"));

        if(turnOrder(arrTable)) {
            table[i][j] = "X";
            arrTable[i][j] = 1;
        } else {
        table[i][j] = "O";
        arrTable[i][j] = 2;}

        System.out.println("Making move level \"easy\" ");
        getTable(table);
    }

    public static void mediumBotMove(){
        int a = 0;
        int b = 0;
        int i;
        int j;
        int loopDetection = 0;


        if (turnOrder(arrTable)){
            for(i = 0; i < columnsAndRows; i ++) {
                for (j = 0; j < columnsAndRows; j++) {
                    if (arrTable[i][a] == 1 && arrTable[i][a + 1] == 1 && arrTable[i][a + 2] == 0) {
                        arrTable[i][a + 2] = 1;
                        table[i][a + 2] = "X";
                        loopDetection++;
                    } else if (arrTable[i][a] == 1 && arrTable[i][a + 2] == 1 && arrTable[i][a + 1] == 0) {
                        arrTable[i][a + 1] = 1;
                        table[i][a + 1] = "X";
                        loopDetection++;
                    } else if (arrTable[i][a + 1] == 1 && arrTable[i][a + 2] == 1 && arrTable[i][a] == 0) {
                        arrTable[i][a] = 1;
                        table[i][a] = "X";
                        loopDetection++;
                    } else if (arrTable[b + 1][j] == 1 && arrTable[b][j] == 1 && arrTable[b + 2][j] == 0) {
                        arrTable[b + 2][j] = 1;
                        table[b + 2][j] = "X";
                        loopDetection++;
                    } else if (arrTable[b + 2][j] == 1 && arrTable[b][j] == 1 && arrTable[b + 1][j] == 0) {
                        arrTable[b + 1][j] = 1;
                        table[b + 1][j] = "X";
                        loopDetection++;
                    } else if (arrTable[b + 1][j] == 1 && arrTable[b + 2][j] == 1 && arrTable[b][j] == 0) {
                        arrTable[b][j] = 1;
                        table[b][j] = "X";
                        loopDetection++;
                    } else if (arrTable[a][b] == 1 && arrTable[a + 1][b + 1] == 1 && arrTable[a + 2][b + 2] == 0) {
                        arrTable[a + 2][b + 2] = 1;
                        table[a + 2][b + 2] = "X";
                        loopDetection++;
                    } else if (arrTable[a][b] == 1 && arrTable[a + 2][b + 2] == 1 && arrTable[a + 1][b + 1] == 0) {
                        arrTable[a + 1][b + 1] = 1;
                        table[a + 1][b + 1] = "X";
                        loopDetection++;
                    } else if (arrTable[a + 1][b + 1] == 1 && arrTable[a + 2][b + 2] == 1 && arrTable[a][b] == 0) {
                        arrTable[a][b] = 1;
                        table[a][b] = "X";
                        loopDetection++;
                    } else if (arrTable[a][b + 2] == 1 && arrTable[a + 1][b + 1] == 1 && arrTable[a + 2][b] == 0) {
                        arrTable[a + 2][b] = 1;
                        table[a + 2][b] = "X";
                        loopDetection++;
                    } else if (arrTable[a + 2][b] == 1 && arrTable[a + 1][b + 1] == 1 && arrTable[a][b + 2] == 0) {
                        arrTable[a][b + 2] = 1;
                        table[a][b + 2] = "X";
                        loopDetection++;
                    } else if (arrTable[a][b + 2] == 1 && arrTable[a + 2][b] == 1 && arrTable[a + 1][b + 1] == 0) {
                        arrTable[a + 1][b + 1] = 1;
                        table[a + 1][b + 1] = "X";
                        loopDetection++;
                    }
                }
            }

            if (loopDetection == 0) {
                do {
                    i = (int) (Math.random() * 3);
                    j = (int) (Math.random() * 3);
                } while (table[i][j].equals("O") || table[i][j].equals("X"));
                table[i][j] = "X";
                arrTable[i][j] = 1;
            }

        } else {
            for (i = 0; i < columnsAndRows; i++) {
                for (j = 0; j < columnsAndRows; j++) {
                    if (arrTable[i][a] == 2 && arrTable[i][a + 1] == 2 && arrTable[i][a + 2] == 0) {
                        arrTable[i][a + 2] = 2;
                        table[i][a + 2] = "O";
                        loopDetection++;
                    } else if (arrTable[i][a] == 2 && arrTable[i][a + 2] == 2 && arrTable[i][a + 1] == 0) {
                        arrTable[i][a + 1] = 2;
                        table[i][a + 1] = "O";
                        loopDetection++;
                    } else if (arrTable[i][a + 1] == 2 && arrTable[i][a + 2] == 2 && arrTable[i][a] == 0) {
                        arrTable[i][a] = 2;
                        table[i][a] = "O";
                        loopDetection++;
                    } else if (arrTable[b + 1][j] == 2 && arrTable[b][j] == 2 && arrTable[b + 2][j] == 0) {
                        arrTable[b + 2][j] = 2;
                        table[b + 2][j] = "O";
                        loopDetection++;
                    } else if (arrTable[b + 2][j] == 2 && arrTable[b][j] == 2 && arrTable[b + 1][j] == 0) {
                        arrTable[b + 1][j] = 2;
                        table[b + 1][j] = "O";
                        loopDetection++;
                    } else if (arrTable[b + 1][j] == 2 && arrTable[b + 2][j] == 2 && arrTable[b][j] == 0) {
                        arrTable[b][j] = 2;
                        table[b][j] = "O";
                        loopDetection++;
                    } else if (arrTable[a][b] == 2 && arrTable[a + 1][b + 1] == 2 && arrTable[a + 2][b + 2] == 0) {
                        arrTable[a + 2][b + 2] = 2;
                        table[a + 2][b + 2] = "O";
                        loopDetection++;
                    } else if (arrTable[a][b] == 2 && arrTable[a + 2][b + 2] == 2 && arrTable[a + 1][b + 1] == 0) {
                        arrTable[a + 1][b + 1] = 2;
                        table[a + 1][b + 1] = "O";
                        loopDetection++;
                    } else if (arrTable[a + 1][b + 1] == 2 && arrTable[a + 2][b + 2] == 2 && arrTable[a][b] == 0) {
                        arrTable[a][b] = 2;
                        table[a][b] = "O";
                        loopDetection++;
                    } else if (arrTable[a][b + 2] == 2 && arrTable[a + 1][b + 1] == 2 && arrTable[a + 2][b] == 0) {
                        arrTable[a + 2][b] = 2;
                        table[a + 2][b] = "O";
                        loopDetection++;
                    } else if (arrTable[a + 2][b] == 2 && arrTable[a + 1][b + 1] == 2 && arrTable[a][b + 2] == 0) {
                        arrTable[a][b + 2] = 2;
                        table[a][b + 2] = "O";
                        loopDetection++;
                    } else if (arrTable[a][b + 2] == 2 && arrTable[a + 2][b] == 2 && arrTable[a + 1][b + 1] == 0) {
                        arrTable[a + 1][b + 1] = 2;
                        table[a + 1][b + 1] = "O";
                        loopDetection++;
                    }
                }
            }
            if (loopDetection == 0) {
                do {
                    i = (int) (Math.random() * 3);
                    j = (int) (Math.random() * 3);
                } while (table[i][j].equals("O") || table[i][j].equals("X"));
                table[i][j] = "O";
                arrTable[i][j] = 2;

            }
        }
        System.out.println("Making move level \"medium\" ");
        getTable(table);
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
    public static int gameModeSelection(){
        int enteredValues;
        System.out.println("\t" + "Select game mode:");
        System.out.println("\t" + "[1] - bot vs bot   " + " [2] - bot vs player\n" + "\t[3] - player vs player");
        enteredValues = in.nextInt();
        return enteredValues;
    }
    public static int enemyDifficultySelection(int gameMode){
        int enteredValues;
        if (gameMode == 1 || gameMode == 2) {
        System.out.println("\t" + "Select enemy difficulty:");
        System.out.println("\t" + "[1] - easy bot   " + " [2] - medium bot\n" + "\t[3] - hard bot");
        enteredValues = in.nextInt();}
        else {enteredValues = 0;}
        return enteredValues;
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
        int gameMode = gameModeSelection();
        int enemyDifficulty = enemyDifficultySelection(gameMode);
        while (true) {
            if (!won) {
                switch (gameMode) {
                    case 1:
                        if(enemyDifficulty == 1){
                            easyBotMove();
                            victoryCheck(table,arrTable);
                            break;
                        } else if (enemyDifficulty == 2) {
                            mediumBotMove();
                            victoryCheck(table,arrTable);
                            break;
                        }
                        break;
                    case 2:
                        if (enemyDifficulty == 1){
                            playerMove();
                            victoryCheck(table,arrTable);
                            if(!won){
                            easyBotMove();
                            victoryCheck(table,arrTable);}
                        } else if (enemyDifficulty == 2) {
                            playerMove();
                            victoryCheck(table,arrTable);
                            if(!won){
                            mediumBotMove();
                            victoryCheck(table,arrTable);}
                        }
                        break;
                    case 3:
                        playerMove();
                        victoryCheck(table,arrTable);
                        break;
                }
            }else {
                System.out.println();
                break;
            }
        }
    }
}
