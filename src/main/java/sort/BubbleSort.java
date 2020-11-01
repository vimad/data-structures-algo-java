package sort;

import java.util.Arrays;
/*
    O(n^2) time complexity
    Stable sort algorithm
 */
public class BubbleSort {

    public static int[] sort(int[] arr) {

        for (int unsortedPartitionIndex= arr.length - 1; unsortedPartitionIndex > 0; unsortedPartitionIndex--) {
            for (int i = 0; i < unsortedPartitionIndex; i++) {

                if (arr[i+1] < arr[i]) {
                    swap(arr, i, i+1);
                }
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
        System.out.println("Bubble Sort");
        System.out.println(Arrays.toString(sort(test)));
    }
}
