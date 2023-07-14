
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] splittedInput = input.split("-");
        String first = splittedInput[0];
        String second = splittedInput[1];
        String last = splittedInput[2];
        System.out.println(second + "/" + last + "/" + first);
    }
}