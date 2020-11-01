package sort;

import java.util.Arrays;

/*
    Data must have same width and radix
    Hence data must be integer or string
    O(n) time complexity
    Stable sort algorithm
 */
public class RadixSort {

    public static void sort(int[] arr, int radix, int width) {
        for (int i=0; i<width; i++) {
            radixSingleSort(arr, i, radix);
        }
    }

    private static void radixSingleSort(int[] arr, int position, int radix) {
        int numItems = arr.length;
        int[] countArray = new int[radix];

        for (int value: arr) {
            countArray[getDigit(position, value, radix)]++;
        }
        for (int j=1; j<radix; j++) {
            countArray[j] += countArray[j-1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems -1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, arr[tempIndex], radix)]] = arr[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            arr[tempIndex] = temp[tempIndex];
        }

    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }

    public static void main(String[] args) {
        int[] test = {4725, 4586, 1330, 8792, 1594, 5729};
        System.out.println("Radix Sort");
        sort(test, 10, 4);
        System.out.println(Arrays.toString(test));
    }

}
