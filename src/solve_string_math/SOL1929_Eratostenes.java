package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SOL1929_Eratostenes {
    public static void main(String[] args) throws IOException {

        // 에라토스테네스로 소수 판별 문제

        // 1 ≤ M ≤ N ≤ 1,000,000 , 시간 제한 2초
        // o (n^2) 연산 시 2초 초과
        // 1초 -> 1억회 정도
        // o (nlong) 이하의 알고리즘 사용 -> 에라토스테네스 or 제곱근 판별


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(str);

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        sieve(a,b);

    }

    // 제곱근으로 판별
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i=2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // 에라토스테네스 방식
    public static void sieve(int a, int limit) {
        boolean isPrime[] = new boolean[limit+1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        int limitSqrt = (int) Math.sqrt(limit);

        for (int i = 2; i <= limitSqrt; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= limit; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i=a; i <= limit; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }

    }
}
