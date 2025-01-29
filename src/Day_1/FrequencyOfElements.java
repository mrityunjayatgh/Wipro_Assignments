// 9.Write a program to find the frequency of each element in an array.
// Use nested loops with conditional operators to count unique occurrences.

package Day_1;
import java.util.Scanner;

public class FrequencyOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        boolean[] visited = new boolean[n];

        System.out.println("Element frequencies:");
        for (int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(array[i] + ": " + count);
        }

        scanner.close();
    }
}

