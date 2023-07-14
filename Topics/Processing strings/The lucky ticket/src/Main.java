import java.util.Scanner;

class Main {
    public static final int CONTROL_DIGITS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ticketNumber = scanner.nextLine();
        int sumOfFirstThreeDigits = 0;
        int sumOfLastThreeDigits = 0;
        for (int i = 0; i < CONTROL_DIGITS; i++) {
            sumOfFirstThreeDigits += ticketNumber.charAt(i);
        }
        for (int i = CONTROL_DIGITS; i < ticketNumber.length(); i++) {
            sumOfLastThreeDigits += ticketNumber.charAt(i);
        }
        if (sumOfFirstThreeDigits == sumOfLastThreeDigits) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}