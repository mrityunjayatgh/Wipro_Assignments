//8. Write a program to count vowels and consonants in a given string.
// Use conditional statements and the switch operator for checking vowel/consonant conditions.

package Day_1;
import java.util.Scanner;

public class VowelAndConsonantCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String lowerCaseInput = input.toLowerCase();

        int vowelCount = 0, consonantCount = 0;

        for (int i = 0; i < lowerCaseInput.length(); i++) {
            char ch = lowerCaseInput.charAt(i);
            if(ch>='a' && ch<='z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);

        scanner.close();
    }
}

