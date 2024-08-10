package concept_string_math;

import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        // 에라토스테네스 체 방식
        // 주어진 범위 내의 모든 소수를 효율적으로 찾는 알고리즘

        int limit = 50;
        sieve(50);
    }

    public static void sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);

        // 0 , 1은 소수가 아님으로 false
        isPrime[0] = false;
        isPrime[1] = false;

        int sqrtLimit = (int) Math.sqrt(limit);
        for (int p=2; p <= sqrtLimit; p++) {
            if (isPrime[p]) {
                // isPrime[p] 는 처음에 true로 초기화
                // p의 배수들은 소수가 아니라고 표시
                // p는 2 부터 제곱근보다 같거나 작은 수
                for (int multiple = p * p; multiple <= limit; multiple += p) {
                    // p의 배수 중에서 가장 작은 수는 p * p 이다.
                    // p * p 보다 작은 배수들은 이미 이전 소수에 의해서 제거  -> 효율적
                    // multiple += p -> 한 번에 다음 배수로 이동

                    // 예시
                    // 50
                    // p는 2 ~ 7
                    // 4 , 6 , 8 ... 50 -> false
                    // 9 , 15 , ... -> false
                    // 25 -> false
                    // 49 -> false

                    // 정리하자면
                    // 제곱근의 제곱부터 반복문을 시작하여 중복 제거 및 최적화
                    // 다음 배수로 바로 이동

                    isPrime[multiple] = false;
                }
            }
        }

        // 소수 출력
        System.out.println("Prime numbers up to " + limit + ":");
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
