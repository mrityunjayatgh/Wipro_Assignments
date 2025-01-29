//Write a program to find the maximum sum of a contiguous subarray in a given array.
// Use conditional operators to update the maximum sum dynamically.


package Day_1;

public class SubarraySum {
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = findMaximumSubarraySum(array);
        System.out.println("Maximum sum of a contiguous subarray: " + maxSum);
    }

    public static int findMaximumSubarraySum(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : array) {
            currentSum=currentSum+num;
            if(currentSum>maxSum) maxSum=currentSum;

            if(currentSum<0) currentSum=0;
        }

        return maxSum;
    }
}
