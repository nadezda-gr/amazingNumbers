import java.util.Scanner;

class EvenUpperCase {

    public static String upperEvenLetters(String message) {
        String upperString = message.toUpperCase();
        StringBuilder sb = new StringBuilder(message);
        for (int i = 0; i < message.length(); i+=2) {
            sb.setCharAt(i, upperString.charAt(i));
        }
        return sb.toString();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        System.out.println(upperEvenLetters(message));
    }
}