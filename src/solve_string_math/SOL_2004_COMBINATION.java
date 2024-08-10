package solve_string_math;

import java.util.Scanner;

public class SOL_2004_COMBINATION {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong(); // 25
        long b = scanner.nextLong(); // 12

        long countOfTwo = countFactors(n, 2) - countFactors(b, 2) - countFactors(n - b, 2);
        long countOfFive = countFactors(n, 5) - countFactors(b, 5) - countFactors(n - b, 5);

        System.out.println(Math.min(countOfTwo, countOfFive));
    }

    // n!에서 소수 p가 몇 번 곱해지는지 세는 함수
    public static long countFactors(long n, int p) {
       long count = 0;
       while (n >= p) {
           count += n / p;
           n = n/p;
       }
       return count;
    }
}
