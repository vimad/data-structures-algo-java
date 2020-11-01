package sort;

import java.util.Arrays;

/*
    O(n^2) time complexity
    Unstable sort algorithm
 */
public class SelectionSort {

    public static int[] sort(int[] arr) {

        for (int unsortedPartitionIndex=arr.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
            int largestIndex = 0;
            for (int j=1; j < unsortedPartitionIndex; j++) {
                if (arr[j] > arr[largestIndex]) {
                    largestIndex = j;
                }
            }
            if (arr[largestIndex] > arr[unsortedPartitionIndex]) {
                swap(arr, largestIndex, unsortedPartitionIndex);
            }

        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {10,5,1,4,14,-5,8,-10};
        System.out.println("Selection Sort");
        System.out.println(Arrays.toString(sort(test)));
    }
}
