package solve_string_math;

import java.util.Scanner;

public class SOL_2004_COMBINATION {

    // 0 <= m <= n <= 2,000,000,000 , n != 0
    // 제한 시간 2초

    // 기본 팩토리얼 구하는 연산시 O(n^2) 시간복잡도 발생 -> 불가능
    // 무조건 O(n)의 시간 안에 해결해야 함

    // 문제는 조합의 (n가지중 m개를 뽑을 때) 끝자리 0의 개수를 출력하는 문제

    // 끝자리가 0이다 -> 10으로 나누어 떨어진다.
    // 10은 소인수 분해시 2 * 5 의 곱으로 이루어짐

    // 기본 조합의 공식은 n! / r!(n-r)!

    // O(N)의 시간복잡도로 해결하기 위해서는
    // 팩토리얼을 계산할때 전체 팩토리얼 전부를 구하는 것이 아닌
    // 2의 곱으로 이루어진 수  || 5의 곱으로 이루어진 수 중에서 최소값 기준으로 소거하여
    // 특정 팩토리얼을 구할 때 , 2 || 5 가 몇 번 곱해졌는지를 구해야 함

    // 왜 ? why
    // 만약 2^3 , 5^2 라면 (2*5)^2 * 2 로 분리할 수 있음
    // 즉 10을 만족하는 최소한의 수를 구해야 하는 것



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
