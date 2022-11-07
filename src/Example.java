import java.util.Scanner;

public class Example {
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

    public static char[][] convert1DTo2D(char[] a) {
        int columns = 3;
        int rows = a.length / columns;
        double s = (double) a.length / (double) columns;
        if (s % 2 != 0) {
            rows += 1;
        }
        char[][] TRAN = new char[rows][];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            TRAN[i] = (i + 1 < rows) ? new char[columns] : new char[a.length % columns];
            for (int j = 0; j < columns; j++) {
                if (count == a.length) break;
                TRAN[i][j] = a[count];
                count++;
            }
        }
        return TRAN;
    }
    public static boolean draw(int[][] arrTable){
        int ret = 0;
        for (int i = 0; i < 3;i++){
            for (int j = 0; j < 3;j++){
                if (arrTable[i][j] != 0){
                    ret ++;
                }
            }
        }

        return ret >= 9;
    }

    public static int turnOrder(int[][] arrTable) {
        int keyX = 0;
        int keyO = 0;
        int keyZero = 0;
        int ret = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arrTable[i][j] != 0){
                    if (arrTable[i][j] == 1) {
                    keyX += 1;
                    } else if (arrTable[i][j] > 1) {
                    keyO += 1;
                    }
                }else keyZero += 1;
            }
        }if (keyX > keyO){
            ret = 1;
        } else if (keyO > keyX) {
            ret = 0;
        } else if (keyO == keyX){
            ret = 1;
        }
        return ret;
    }

    static void getTable(String[][] table){
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

        Scanner in = new Scanner(System.in);

        int a = 3;
        int b = 3;
        boolean Won = false;

        int[][] arrTable = new int[3][3];
        for (int i = 0; i < arrTable.length; i++) {
            for (int j = 0; j < arrTable.length; j++) {
                arrTable[i][j] = 0;
            }
        }

        String[][] table = new String[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = "table(" + i + ")(" + j + ")";
            }
        }

        char[] tran;
        while (true) {
            System.out.print("Enter the cells: ");
            String cells = in.nextLine();
            if (cells.isEmpty()) {
                System.out.println("String is empty");
            }
            tran = cells.toCharArray();
            if (tran.length == 9) {
                System.out.println("\t" + "---------");
                for (int i = 0, n = 0; i < tran.length; i++, n++) {
                    if (n == 3) {
                        System.out.println();
                        n = 0;
                    }
                    System.out.print("\t" + tran[i]);
                }
                System.out.println();
                System.out.println("\t" + "---------");
                break;
            } else System.out.println("Введите 9 символов");
        }


        char[][] tranConvert = convert1DTo2D(tran);



        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (tranConvert[i][j] == '_') {
                    table[i][j] = "_";
                } else if (tranConvert[i][j] == 'X') {
                    table[i][j] = "X";
                } else if (tranConvert[i][j] == 'O') {
                    table[i][j] = "O";
                }
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (table[i][j] == "_") {
                    arrTable[i][j] = 0;
                } else if (table[i][j] == "X") {
                    arrTable[i][j] = 1;
                } else if (table[i][j] == "O") {
                    arrTable[i][j] = 2;
                }
            }
        }

        while (true) {
            if (!Won) {
                while (true) {
                    System.out.print("Enter the coordinates: ");
                    if (in.hasNextInt()) {
                        int first = in.nextInt();
                        int second = in.nextInt();
                        if (first > 3 || first <= 0) {
                            System.out.println("Coordinates should be from 1 to 3!");
                            continue;
                        } else if (second > 3 || second <= 0) {
                            System.out.println("Coordinates should be from 1 to 3!");
                            continue;
                        } else {
                            if (arrTable[first - 1][second - 1] == 1 || arrTable[first - 1][second - 1] == 2) {
                                System.out.println("This cell is occupied! Choose another one!");
                                continue;
                            } else if (turnOrder(arrTable) == 1) {
                                table[first - 1][second - 1] = "X";
                                arrTable[first - 1][second - 1] = 1;
                                break;
                            } else {
                                table[first - 1][second - 1] = "O";
                                arrTable[first - 1][second - 1] = 1;
                                break;
                            }
                        }
                    } else if (in.hasNextLine()) {
                        String costil = in.nextLine();
                        System.out.println("You should enter numbers!");
                        continue;

                    }
                }

                getTable(table);
                easyBotMove(table,arrTable);


                if (table[0][0] == table[0][1] & table[0][1] == table[0][2] & table[0][0] == "X") {
                    Won = true;
                    System.out.println("\t" + "X wins");
                    break;
                } else if (table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] == "O") {
                    Won = true;
                    System.out.println("\t" + "O wins");
                    break;
                } else if (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == "X") {
                    Won = true;
                    System.out.println("\t" + "X wins");
                    break;
                } else if (table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == "O") {
                    Won = true;
                    System.out.println("\t" + "O wins");
                    break;
                } else if (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][0] == "X") {
                    Won = true;
                    System.out.println("\t" + "X wins");
                    break;
                } else if (table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][0] == "O") {
                    Won = true;
                    System.out.println("\t" + "O wins");
                    break;
                } else if (table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == "X") {
                    Won = true;
                    System.out.println("\t" + "X wins");
                    break;
                } else if (table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == "O") {
                    Won = true;
                    System.out.println("\t" + "O wins");
                    break;
                } else if (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == "X") {
                    Won = true;
                    System.out.println("\t" + "X wins");
                    break;
                } else if (table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == "O") {
                    Won = true;
                    System.out.println("\t" + "O wins");
                    break;
                } else if (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == "X") {
                    Won = true;
                    System.out.println("\t" + "X wins");
                    break;
                } else if (table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == "O") {
                    Won = true;
                    System.out.println("\t" + "O wins");
                    break;
                } else if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == "X") {
                    Won = true;
                    System.out.println("\t" + "X wins");
                    break;
                } else if (table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == "O") {
                    Won = true;
                    System.out.println("\t" + "O wins");
                    break;
                } else if (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == "X") {
                    Won = true;
                    System.out.println("\t" + "X wins");
                    break;
                } else if (table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == "O") {
                    Won = true;
                    System.out.println("\t" + "O wins");
                    break;
                }else if (draw(arrTable) && !Won) {
                    Won = true;
                    System.out.println("\t" + "Draw");
                    break;
                }else Won = false;

                System.out.println("Game not finished");
        }else {
                System.out.println();
                break;

            }


        }

    }
}
