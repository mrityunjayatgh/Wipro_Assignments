//Write a program to check if a given string is a palindrome.
//Use string manipulation and conditional statements to handle case sensitivity and ignore spaces.

package Day_1;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama";
        System.out.println("Is palindrome? " + isPalindrome(input));
    }
}