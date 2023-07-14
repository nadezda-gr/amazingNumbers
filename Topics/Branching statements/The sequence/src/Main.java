
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int counter = 0;
        int s = 0;

        for (int i = 0; i < n; i++) {
            s += 1;
            for (int j = 0; j < s; j++) {
                if (counter == n) {
                    break;
                }
                System.out.print(s + " ");
                counter += 1;
            }
        }
    }
}