package sort;

import java.util.Arrays;
/*
    O(n^2) time complexity
    Stable sort algorithm
 */
public class InsertionSort {

    public static int[] sort(int[] arr) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int currentInsertValue = arr[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && arr[i-1] > currentInsertValue; i--) {
                arr[i] = arr[i-1];
            }
            arr[i] = currentInsertValue;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] test = {10,5,1,4,14,-5,8,-10};
        System.out.println("Insertion Sort");
        System.out.println(Arrays.toString(sort(test)));
    }
}
