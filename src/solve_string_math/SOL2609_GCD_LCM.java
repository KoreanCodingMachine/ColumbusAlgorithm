package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SOL2609_GCD_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(line, " ");

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }

    public static int gcd(int a, int b) {
        // r = a % b;
        // a = b , b = r
        // b가 0이기 전까지
        // return a
        int tmp = 0;
        while (b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }

    public static int lcm(int a, int b) {
        return Math.abs(a*b) / gcd(a,b);
    }
}
