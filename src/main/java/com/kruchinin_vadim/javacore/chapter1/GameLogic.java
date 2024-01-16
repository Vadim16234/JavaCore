package com.kruchinin_vadim.javacore.chapter1;

import java.util.Scanner;

public class GameLogic {
    private final Field field = new Field();
    private final Scanner scanner = new Scanner(System.in);
    private final String X_PLAYER = "X";
    private final String O_COMP = "O";

    public void start() {
        field.createMatrix();
        field.showMatrix();

        while (true) {
            playerMove();
            field.showMatrix();

            if (checkGameWin(X_PLAYER)) {
                System.out.println("Поздравляю!!! Вы победили!!!");
                break;
            }
            if (checkDraw()) {
                System.out.println("Ничья. Игра завершена.");
                break;
            }

            compMove();
            field.showMatrix();
            if (checkGameWin(O_COMP)) {
                System.out.println("Победил компьютер. В другой раз повезет");
                break;
            }
            if (checkDraw()) {
                System.out.println("Ничья. Игра завершена.");
                break;
            }
        }
    }

    public boolean checkDraw() {
        for (int i = 0; i < field.getMatrix().length; i++) {
            for (int j = 0; j < field.getMatrix().length; j++) {
                if (field.getMatrix()[i][j] == field.getNOT_NULL()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkGameWin(String player) {
        // проверка по горизонтали
        if (field.getMatrix()[0][0] == player && field.getMatrix()[0][1] == player && field.getMatrix()[0][2] == player) {
            return true;
        }
        if (field.getMatrix()[1][0] == player && field.getMatrix()[1][1] == player && field.getMatrix()[1][2] == player) {
            return true;
        }
        if (field.getMatrix()[2][0] == player && field.getMatrix()[2][1] == player && field.getMatrix()[0][2] == player) {
            return true;
        }

        // проверка по вертикали
        if (field.getMatrix()[0][0] == player && field.getMatrix()[1][0] == player && field.getMatrix()[2][0] == player) {
            return true;
        }
        if (field.getMatrix()[0][1] == player && field.getMatrix()[1][1] == player && field.getMatrix()[2][1] == player) {
            return true;
        }
        if (field.getMatrix()[0][2] == player && field.getMatrix()[1][2] == player && field.getMatrix()[2][2] == player) {
            return true;
        }

        // проверка по диагонали
        if (field.getMatrix()[0][0] == player && field.getMatrix()[1][1] == player && field.getMatrix()[2][2] == player) {
            return true;
        }
        if (field.getMatrix()[0][2] == player && field.getMatrix()[1][1] == player && field.getMatrix()[2][0] == player) {
            return true;
        }
        return false;
    }

    public boolean checkValid(int x, int y) {
        if (x < 0 || y < 0 || x >= field.getMatrix().length || y >= field.getMatrix().length) {
            return false;
        }
        if (field.getMatrix()[y][x] != field.getNOT_NULL()) {
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
        field.getMatrix()[y][x] = X_PLAYER;
    }

    public void compMove() {
        int x, y;
        System.out.println("Ход компьютера: ");
        do {

            x = (int) (Math.random() * field.getMatrix().length);
            y = (int) (Math.random() * field.getMatrix().length);
        } while (!checkValid(x, y));
        field.getMatrix()[y][x] = O_COMP;
    }
}
