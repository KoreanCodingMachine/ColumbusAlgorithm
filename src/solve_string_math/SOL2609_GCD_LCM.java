package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SOL2609_GCD_LCM {

    // 최대공약수 , 최소공배수 찾는 문제

    // 시간 제한 1초
    // 첫째 줄에는 두 개의 자연수가 주어진다.
    // 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
    // O(n^2) 시 딱 1초정도 소요

    // 상관은 없지만 ,
    // 유클리드 알고리즘 사용 (O(log(min(a,b))))


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
