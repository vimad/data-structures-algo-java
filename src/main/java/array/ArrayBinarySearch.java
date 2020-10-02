package array;

import java.util.Arrays;

public class ArrayBinarySearch {

    static int[] array = {2,3,5,6,8,10,12,14};

    public static int binarySearchWithLoop(int[] arr, int searchInt) {
        int l = 0;
        int h = arr.length;

        while (l <= h) {
            int m = (h+l)/2;
            if (arr[m] == searchInt) {
                return m;
            } else if (searchInt < arr[m]) {
                h = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }

    public static int binarySearchWithRecursion(int l, int h, int searchInt) {
        if (l <= h) {
            int m = (l+h)/2;
            if (array[m] == searchInt) {
                return m;
            } else if (searchInt < array[m]) {
                return binarySearchWithRecursion(l, m-1, searchInt);
            } else {
                return binarySearchWithRecursion(m+1, h, searchInt);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,8,9,12};
        System.out.println(binarySearchWithLoop(arr, 1));
        System.out.println(binarySearchWithRecursion(0, 8,12));
    }
}
