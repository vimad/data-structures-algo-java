package recursion;

public class Power {

    static long computePower(long m, long n) {
        if (n == 0) {
            return 1;
        }
        return m * computePower(m, n -1);
    }

    public static void main(String[] args) {
        System.out.println(computePower(3,5));
    }
}
