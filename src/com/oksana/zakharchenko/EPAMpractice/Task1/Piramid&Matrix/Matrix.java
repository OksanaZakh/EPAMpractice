package Task1;

import java.util.Random;

public class Matrix {

    public void run(int size) {
        int[][] matrix = generateMatrix(size);
        print(matrix);
        System.out.println("");
        print(rotate(matrix));
    }


    private int[][] rotate(int[][] matrix) {
        int size = matrix.length;
        int[][] rotatedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                rotatedMatrix[size - j - 1][i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    private int[][] generateMatrix(int size) {
        Random rnd = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rnd.nextInt(10);
            }
        }
        return matrix;
    }

    private void print(int[][] matrix) {
        for (int i=0; i<matrix.length; i++){
            for (int k=0; k<matrix[i].length; k++){
                System.out.print(matrix[i][k]+" ");
            }
            System.out.println();
        }
    }
}
