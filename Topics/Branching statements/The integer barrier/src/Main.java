import java.util.Scanner;

class Main {

    public static final int LIMIT_NUMBER = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumOfNumbers = 0;
        while (sumOfNumbers < LIMIT_NUMBER) {
            int number = scanner.nextInt();
            sumOfNumbers += number;
            if (number == 0) {
                System.out.println();
                System.out.println(sumOfNumbers);
                break;
            } else if (sumOfNumbers >= LIMIT_NUMBER) {
                System.out.println();
                System.out.println(sumOfNumbers - LIMIT_NUMBER);
                break;
            }
        }
    }
}