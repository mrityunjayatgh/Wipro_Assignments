//Write a program to rotate an array n times to the right or left based on user input.
//Use conditional statements to handle boundary conditions.

package Day_1;

import java.util.Arrays;

public class ArrayRotation {
    public static void rotateArray(int[] arr, int n, boolean left) {
        n = n % arr.length; // Handle rotations larger than array length
        if (left) n = arr.length - n; // Convert left rotation to right

        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, n, arr.length - 1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotateArray(arr, 2, true); // Rotate left
        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }
}