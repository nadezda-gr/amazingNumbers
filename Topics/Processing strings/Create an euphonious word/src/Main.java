import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int count = 0;
        int maxConsecutive = 3; // Maximum number of consecutive vowels or consonants allowed

        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            int consecutive = 1;

            // Check for consecutive vowels or consonants
            while (i + 1 < word.length() && isVowel(word.charAt(i + 1)) == isVowel(current)) {
                consecutive++;
                i++;
            }

            // Increment count if consecutive vowels or consonants exceed the maximum allowed
            if (consecutive >= maxConsecutive) {
                count += (consecutive - maxConsecutive) / 2 + 1;
            }
        }

        System.out.println(count);
    }

    private static boolean isVowel(char letter) {
        String vowels = "aeiouy";
        return vowels.indexOf(letter) != -1;
    }
}