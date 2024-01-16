package com.kruchinin_vadim.javacore.chapter1;

public class Field {
    private final String NOT_NULL = "*";
    private final String[][] matrix;

    public Field() {
        matrix = new String[3][3];
    }

    public String getNOT_NULL() {
        return NOT_NULL;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void createMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = NOT_NULL;
            }
        }
    }

    public void showMatrix() {
        for (int i = 0; i <= matrix.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
