package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SOL_1373_BASE_CONVERSION {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        // 2진수 -> 10진수 -> 8진수
        BigInteger bigInteger = new BigInteger(str , 2);
        String answer = bigInteger.toString(8);

        System.out.println(answer);
    }
}
