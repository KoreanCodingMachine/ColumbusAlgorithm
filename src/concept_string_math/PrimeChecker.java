package concept_string_math;

public class PrimeChecker {
    public static void main(String[] args) {
        System.out.println(isPrime(2));
    }

    public static boolean isPrime(int n) {
        // 1은 소수이다.
        if (n == 1) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);
        System.out.println(sqrt);

        // 2 , 3 은 소수이지만 2보다 작은 수기 때문에 실행 x
        for (int i=2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
