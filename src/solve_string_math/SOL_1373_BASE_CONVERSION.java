package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SOL_1373_BASE_CONVERSION {

    // 첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.
    // 제한시간 1초
    // O(n^2)연산 불가

    // 2진수 -> 10진수 -> 8진수 변환

    // 그냥 int , long 으로 변환 시
    // 2^1000000 이라는 큰 숫자를 저장할 수 없음
    // -> BigInteger 사용으로 메모리 초과 오류 해결


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        // 2진수 -> 10진수 -> 8진수
        BigInteger bigInteger = new BigInteger(str , 2);
        String answer = bigInteger.toString(8);

        System.out.println(answer);
    }
}
