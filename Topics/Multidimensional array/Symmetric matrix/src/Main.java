import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = scanner.nextInt();
            }

        }

        boolean isSymetric = true;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] != matrix[col][row]) {
                    isSymetric = false;
                    break;
                }
            }
            if (!isSymetric) {
                break;
            }
        }

        if (isSymetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}