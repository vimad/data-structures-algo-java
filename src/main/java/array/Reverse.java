package array;

import java.util.Arrays;

public class Reverse {

    static int[] reverseArray(int[] a) {
        int[] b = new int[a.length];
        for (int i=a.length -1, j = 0; i >= 0; i--, j++)  {
            b[j] = a[i];
        }
        return b;
    }

    static int[] reverseInPlace(int[] a) {
        for (int i=a.length-1, j=0; i > j; i--, j++) {
            int first = a[j];
            a[j] = a[i];
            a[i] = first;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(reverseArray(a)));
        System.out.println(Arrays.toString(reverseInPlace(a)));
    }
}
