package sort;

import java.util.Arrays;

/*
    O(nlogn) time complexity
    Stable sort algorithm
    Not a in-place one
    Split array into half and merge them recursively until entire array get sorted
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSort(arr, start, middle);
        mergeSort(arr, middle, end);
        merge(arr, start, middle, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        if (arr[mid - 1] <= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        /*
            If some thing left over in right array it is mean that those items are still in the correct position
            hence not required any copying
            But if something left in right array it is required to copy.
            Instead of copying them to temp array we can directly copy them to the input array
         */
        System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, arr, start, tempIndex);
    }

    public static void main(String[] args) {
        int[] test = {20,35,-15,7,55,1,-22};
        int[] test2 = {10,5,1,4,14,-5,8,-10};
        System.out.println("Merge Sort");
//        System.out.println("************MY**************");
//        System.out.println(Arrays.toString(sortMy(test, 0, test.length - 1)));
//        System.out.println(Arrays.toString(sortMy(test2, 0, test2.length - 1)));
        System.out.println("*******************************");
        mergeSort(test, 0, test.length);
        System.out.println(Arrays.toString(test));

    }

    public static int[] sortMy(int[] arr, int start, int end) {
        int middle = (start + end) / 2;
        if (start == end) {
            return new int[]{arr[start]};
        } else {
            return mergeMy(sortMy(arr, start, middle), sortMy(arr,middle + 1,end));
        }
    }

    public static int[] mergeMy(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length || j < arr2.length) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    arr[k] = arr1[i];
                    i++;
                } else {
                    arr[k] = arr2[j];
                    j++;
                }
            } else if (i < arr1.length) {
                arr[k] = arr1[i];
                i++;
            } else if(j < arr2.length) {
                arr[k] = arr2[j];
                j++;
            }

            k++;
        }

        return arr;
    }
}
