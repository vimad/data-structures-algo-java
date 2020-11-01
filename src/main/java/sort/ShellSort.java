package sort;

import java.util.Arrays;

/*
    This is a variant of insertion sort
    In insertion sort the gap of checking is one
    Here the idea is to increase the gap first and do some preliminary work
    when gap becomes one it is insertion sort
    but due to the preliminary work the number of shifts can reduced
    There are different ways of choosing gap first and reduce it to one
    The below example base on array length / 2 (iterate until gap becomes 1)
    This method can be used to increase the performance of bubble sort too
 */
public class ShellSort {

    public static int[] sort(int[] arr) {

        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int newElement = arr[i];
                int j = i;
                while(j >= gap && arr[j - gap] > newElement) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = newElement;
            }
        }


        return arr;
    }


    public static void main(String[] args) {
        int[] test = {20,35,-15,7,55,1,-22};
        System.out.println("Shell Sort");
        System.out.println(Arrays.toString(sort(test)));
    }
}
