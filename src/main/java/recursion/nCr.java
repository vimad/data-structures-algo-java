package recursion;

public class nCr {

    static long compute(long n, long r) {
        if (r == 0 || n == r) {
            return 1;
        }
        return compute(n-1, r-1) + compute(n-1, r);
    }

    public static void main(String[] args) {
        System.out.println(compute(3, 1));
    }
}
