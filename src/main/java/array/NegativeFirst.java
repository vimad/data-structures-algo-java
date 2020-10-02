package array;

import java.util.Arrays;

public class NegativeFirst {

    static int[] moveNegativeFirst(int[] a) {
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            while(a[i] < 0) { i++; }
            while(a[j] > 0) { j--; }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, -5, 7, 8, -9, -10, 11};
        System.out.println(Arrays.toString(moveNegativeFirst(a)));
    }
}
