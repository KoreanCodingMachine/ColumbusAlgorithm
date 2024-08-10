package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SOL_10798_STRING {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stringBuilder = new StringBuilder();

        char ch[][] = new char[5][15];

        for (int i=0; i < 5; i++) {
            String str = bufferedReader.readLine();
            for (int j=0; j < str.length(); j++) {
                ch[i][j] = str.charAt(j);
            }

            for (int j=str.length(); j < 15; j++) {
                ch[i][j] = '#';
            }
        }

        for (int i=0; i < 15; i++) {
            for (int j=0; j < 5; j++) {
                if (ch[j][i] != '#' ) {
                    stringBuilder.append(ch[j][i]);
                }
            }
        }

        System.out.println(stringBuilder.toString());

    }
}
