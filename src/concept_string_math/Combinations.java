package concept_string_math;

import java.math.BigInteger;

public class Combinations {
    public static void main(String[] args) {
        int n = 5; // 5개 중에서
        int r = 3; // 3개를 뽑는 경우의 수

        System.out.println(combination(n,r)); // 10
    }

    public static BigInteger combination(int n, int r) {
        // C(n,r) = n! / r!(n-r)!

        return factorial(n)
                .divide(factorial(r)
                .multiply(factorial(n-r)));
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;

        for (int i=2; i <=n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
