package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SOL_11720_STRING {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.readLine();

        int sum = 0;

        String target[] = bufferedReader.readLine().split("");

        for (String  str : target) {
            sum += Integer.parseInt(str);
        }

        System.out.println(sum);


    }
}
