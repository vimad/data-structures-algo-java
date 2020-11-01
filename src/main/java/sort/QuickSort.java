package sort;

import java.util.Arrays;

/*
    O(nlogn) average time complexity
    Unstable sort algorithm
 */
public class QuickSort {

    public static void sort(int[] arr, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(arr, start, end);
        sort(arr, start, pivotIndex);
        sort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {

            while (i < j && arr[--j] >= pivot);
            if (i < j) {
                arr[i] = arr[j];
            }

            while (i < j && arr[++i] <= pivot);
            if (i < j) {
                arr[j] = arr[i];
            }

        }
        arr[j] = pivot;
        return j;
    }

    public static void main(String[] args) {
        int[] test = {20,35,-15,7,55,1,-22};
        System.out.println("Quick Sort");
        sort(test, 0, test.length);
        System.out.println(Arrays.toString(test));
    }
}
