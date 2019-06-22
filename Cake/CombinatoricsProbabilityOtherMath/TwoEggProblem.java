package CombinatoricsProbabilityOtherMath;

/*
 *
 * TODO: review later - triangular series & quadratic formula!!!
 *
 * */
public class TwoEggProblem {

    /*
     *
     * n + (n-1) + (n-2) + ... + 1 = 100
     *
     * n^2 + n - 100 = 0
     *
     * n = (-b +/- sqrt(b^2 - 4ac)) / 2a
     * */
    public static void dropEgg(int floors) {
        int a = 1;
        int b = 1;
        int c = 0 - floors;

        int discriminant = b * b - 4 * a * c;
        double tmp1 = -b * 1.0 / (2 * a);
        double tmp2 = Math.sqrt(discriminant * 1.0 / (2 * a));
        System.out.println("tmp1: " + tmp1);
        System.out.println("tmp2: " + tmp2);
        int n = (int) (tmp1 + tmp2);
        System.out.println("n: " + n);
    }

    public static void main(String[] args) {
        dropEgg(100);
    }
}
