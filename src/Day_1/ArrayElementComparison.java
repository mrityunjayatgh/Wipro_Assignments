//Write a program to compare elements of two arrays of the same size.
//Use conditional operators to print whether each pair of elements is equal, greater, or lesser.

package Day_1;

public class ArrayElementComparison {
    public static void compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("Arrays are of different sizes.");
            return;
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Comparison of index " + i + ": " +
                    (arr1[i] == arr2[i] ? "Equal" : (arr1[i] > arr2[i] ? "Greater" : "Lesser")));
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 7};
        int[] arr2 = {2, 5, 9};
        compareArrays(arr1, arr2);
    }
}
