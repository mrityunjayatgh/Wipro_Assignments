//2. Write a program to check if two strings are anagrams of each other.
// Use arrays to count character occurrences and conditional operators for comparisons.

package Day_1;
import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
        String str1 = "Wipro";
        String str2 = "Iprow";

        if (areAnagrams(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }

    public static boolean areAnagrams(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];

        for (char c : str1.toCharArray()) {
            frequency1[c-'a']++;
        }
        for (char c : str2.toCharArray()) {
            frequency2[c-'a']++;
        }

        return Arrays.equals(frequency1, frequency2);
    }
}

