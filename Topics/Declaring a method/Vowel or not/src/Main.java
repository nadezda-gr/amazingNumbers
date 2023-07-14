import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        boolean letter = false;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == ch) {
                letter = true;
            }
        }
        return letter;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch = scanner.nextLine().charAt(0);
        System.out.println(isVowel(ch) ? "YES" : "NO");
    }
}