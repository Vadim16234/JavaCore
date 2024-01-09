package com.kruchinin_vadim.javacore.chapter1;

public class GameLogic {
    private final Field field = new Field();

    public void start() {
        field.createMatrix();
        field.showMatrix();

        while (true) {
            field.playerMove();
            field.showMatrix();

            if (field.checkGameWin(Field.X_PLAYER)) {
                System.out.println("Поздравляю!!! Вы победили!!!");
                break;
            }
            if (field.checkDraw()){
                System.out.println("Ничья. Игра завершена.");
                break;
            }

            field.compMove();
            field.showMatrix();
            if (field.checkGameWin(Field.O_COMP)) {
                System.out.println("Победил компьютер. В другой раз повезет");
                break;
            }
            if (field.checkDraw()){
                System.out.println("Ничья. Игра завершена.");
                break;
            }
        }
    }
}
