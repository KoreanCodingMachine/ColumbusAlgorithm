package concept_string_math;

public class PrimeFactorization {
    public static void main(String[] args) {
        int number = 60;
        System.out.println("소인수 분해 결과 : " );
        primeFactorize(number);
    }

    public static void primeFactorize(int number) {
        // 1.소수로 나누기

        int sqrt = (int) Math.sqrt(number);
        System.out.println("sqrt " + sqrt);


        for (int i=2; sqrt <= number; i++) {
            int count = 0;

            while (number % i == 0) {
                number /= i;
                // 2 지수 카운트
                count++;
            }

            if (count > 0) {
                System.out.print(i + "^" + count + " ");
            }
        }

        // number > 1 이면 number 자체가 소수이다.
        if (number > 1) {
            System.out.print(number + "^1");
        }

    }
}
