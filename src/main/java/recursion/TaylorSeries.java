package recursion;

//e(x,n) = e^x = 1 + x/1! + x^2/2! + .... + x^n/n!
public class TaylorSeries {

    static double i = 1; // this is for keep power of x
    static double j = 1; // this is to keep factorial values

    static double s = 1;

    static double computeWithStaticVariables(double x, double n) {
        if (n == 0) {
            return 1;
        }
        double r = computeWithStaticVariables(x, n-1);
        i = i * x;
        j = j * n;
        return r + i/j;
    }

    static double compute(double x, double n) {
        if (n == 0) {
            return s;
        }
        s = 1 + (x/n)*s;
        return compute(x, n-1);
    }

    public static void main(String[] args) {
        System.out.println(computeWithStaticVariables(7, 3));
        System.out.println(compute(7, 3));
    }

}
