package com.kruchinin_vadim.javacore.chapter1;

import java.util.Scanner;

public class Field {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int SIZE_MATRIX = 3;
    private static final int NOT_NULL = '*';
    private static final char[][] matrix = new char[SIZE_MATRIX][SIZE_MATRIX];
    public static final char X_PLAYER = 'X';
    public static final char O_COMP = 'O';

    public void createMatrix() {
        for (int i = 0; i < SIZE_MATRIX; i++) {
            for (int j = 0; j < SIZE_MATRIX; j++) {
                matrix[i][j] = NOT_NULL;
            }

        }

    }

    public void showMatrix() {
        for (int i = 0; i <= SIZE_MATRIX; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_MATRIX; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE_MATRIX; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkDraw() {
        for (int i = 0; i < SIZE_MATRIX; i++) {
            for (int j = 0; j < SIZE_MATRIX; j++) {
                if (matrix[i][j] == NOT_NULL) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkGameWin(char player) {
        // проверка по горизонтали
        if (matrix[0][0] == player && matrix[0][1] == player && matrix[0][2] == player) {
            return true;
        }
        if (matrix[1][0] == player && matrix[1][1] == player && matrix[1][2] == player) {
            return true;
        }
        if (matrix[2][0] == player && matrix[2][1] == player && matrix[0][2] == player) {
            return true;
        }

        // проверка по вертикали
        if (matrix[0][0] == player && matrix[1][0] == player && matrix[2][0] == player) {
            return true;
        }
        if (matrix[0][1] == player && matrix[1][1] == player && matrix[2][1] == player) {
            return true;
        }
        if (matrix[0][2] == player && matrix[1][2] == player && matrix[2][2] == player) {
            return true;
        }


        // проверка по диагонали
        if (matrix[0][0] == player && matrix[1][1] == player && matrix[2][2] == player) {
            return true;
        }
        if (matrix[0][2] == player && matrix[1][1] == player && matrix[2][0] == player) {
            return true;
        }
        return false;
    }

    public boolean checkValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE_MATRIX || y >= SIZE_MATRIX) {
            return false;
        }
        if (matrix[y][x] != NOT_NULL) {
            return false;
        }
        return true;
    }

    public void playerMove() {
        int x, y;
        do {
            System.out.print("Ход игрока. Введите номер ячейки: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!checkValid(x, y));
        matrix[y][x] = X_PLAYER;
    }

    public void compMove() {
        int x, y;
        do {
            System.out.println("Ход компьютера: ");
            x = (int) (Math.random() * SIZE_MATRIX);
            y = (int) (Math.random() * SIZE_MATRIX);
        } while (!checkValid(x, y));
        matrix[y][x] = O_COMP;
    }
}




//    public static boolean checkNoNull(char symbolChar) {
//        while (true) {
//            for (int i = 0; i < SIZE_MATRIX; i++) {
//                for (int j = 0; j < SIZE_MATRIX; j++) {
//                    if ((matrix[i][j] == symbolChar && matrix[i][j] == X_PLAYER) ||
//                            (matrix[i][j] == symbolChar && matrix[i][j] == O_COMP)) {
//                        return false;
//                    }
//                    return true;
//                }
//            }
//        }
//    }
//
//    public static boolean checkValid(int x, char symbol) {
//
//        if (x <= 0 || x > LENGTH_MATRIX) {
//            return false;
//        }
//        if (!checkNoNull(symbol)) {
//            return false;
//        }
//        return true;
//    }
//
//    public void playerMove() {
//        int x;
//        char symbol;
//        do {
//            System.out.print("Ход игрока. Введите номер ячейки: ");
//            x = scanner.nextInt();
//            symbol = (char) (x + '0');
//        } while (!checkValid(x, symbol));
//
//        for (int i = 0; i < SIZE_MATRIX; i++) {
//            for (int j = 0; j < SIZE_MATRIX; j++) {
//                if (matrix[i][j] == symbol) {
//                    matrix[i][j] = X_PLAYER;
//                }
//            }
//        }
//    }
//
//    public void compMove() {
//        int d;
//        char symbol;
//        do {
//            System.out.println("Компьютер ходит: ");
//            d = random.nextInt(10);
//            symbol = (char) (d + '0');
//        } while (!checkValid(d, symbol));
//
//        for (int i = 0; i < SIZE_MATRIX; i++) {
//            for (int j = 0; j < SIZE_MATRIX; j++) {
//                if (matrix[i][j] == symbol) {
//                    matrix[i][j] = O_COMP;
//                }
//            }
//        }
//
//    }
//}
