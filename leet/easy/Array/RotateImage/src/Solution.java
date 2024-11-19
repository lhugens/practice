import java.util.Stack;

public class Solution {

    public static void rotate(int[][] matrix) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                stack.add(matrix[i][j]);
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                matrix[i][j] = stack.pop();
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix;

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();


    }


}
