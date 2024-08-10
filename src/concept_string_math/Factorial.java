package concept_string_math;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int number = 5;

        System.out.println(recursion(number));
        System.out.println(loop(number));
        System.out.println(big(number));
    }

    public static long recursion(int n) {
        // 재귀 방식
        // 코드가 간결하지만 , 큰 숫자의 경우 스택 오버플로우 발생 가능성 존재

        // long type으로 선언한 이유
        // 팩토리얼은 수가 기하급수적으로 늘어나기 때문에 범위가 더 큰 long타입이 안정적이다.

        if (n == 0) {
            return 1;
        }

        return n * recursion(n-1);
    }

    public static long loop(int n) {
        // 반복문 사용 방식
        // 일반적으로 성능이 좋고 , 스택 오버플로우 문제가 없음

        long result = 1;

        for (int i=2; i <=n; i++) {
            result *= i;
        }

        return result;
    }

    public static BigInteger big(int n) {
        // 팩토리얼 값이 매우 커질 수 있기 때문에 long , int 타입으로 해결할 수 없는 경우
        // BigInteger 클래스를 활용할 수 있다.

        BigInteger result = BigInteger.ONE;
        for (int i=2; i<=n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }


}
