import java.util.Scanner;

public class Main {

    public static int sign(int n) {
        if (n < 0) {
            n = -1;
        } else if (n > 0) {
            n = 1;
        } else {
            n = 0;
        }
        return n;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}