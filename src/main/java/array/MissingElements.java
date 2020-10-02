package array;

public class MissingElements {

    static void missingElementsInSoredArray(int[] a) {
        int diff = a[0];
        for (int i=0; i<a.length; i++) {
            int newDiff = a[i] - i;
            if(newDiff != diff) {
                while (diff < newDiff) {
                    System.out.println(a[i-1] + (newDiff - diff));
                    diff++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,5,6,8,9,12,13};
        missingElementsInSoredArray(a);
    }
}
