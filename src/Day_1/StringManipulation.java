//1. Write a program to count the frequency of each character in a given string,
// ignoring case sensitivity. Use conditional statements to exclude special characters.


    public class StringManipulation {
        public static void main(String[] args) {
             String input = "Wipro training Program";
             countCharacterFrequency(input);
    }

    public static void countCharacterFrequency(String input) {

        String smallInput = input.toLowerCase();

        int[] frequencies = new int[26];

        for (char c : smallInput.toCharArray()) {
            if (c>='a' && c<='z') {
                frequencies[c-'a']++;
            }
        }

        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                System.out.println((char)(i+'a') + ": " + frequencies[i]);
            }
        }
    }
}

