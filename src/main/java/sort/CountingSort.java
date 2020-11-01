package sort;

import java.util.Arrays;

/*
    Only works with non negative discrete values (can't work with strings and floats)
    Values must be with in a specific range (this range must not be huge)
 */
public class CountingSort {

    public static void sort(int[] arr, int min, int max) {
        int[] countingArray = new int[max - min +1];
        for (int i = 0; i < arr.length; i++) {
            countingArray[arr[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countingArray[i - min] > 0) {
                arr[j++] = i;
                countingArray[i - min]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {2,5,9,8,2,8,7,10,4,3};
        System.out.println("Counting Sort");
        sort(test, 1, 10);
        System.out.println(Arrays.toString(test));
    }
}
