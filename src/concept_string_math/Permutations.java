package concept_string_math;

import java.math.BigInteger;

public class Permutations {
    public static void main(String[] args) {
        // P(n,r) = n! / (n-r)!

        int n = 5; // 5개의 원소 중
        int r = 3; // 3개를 뽑는 경우의 수

        System.out.println(permutation(n,r)); // 60
    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i=2; i <=n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public static BigInteger permutation(int n, int r) {
        return factorial(n).divide(factorial(n-r));
    }
}
