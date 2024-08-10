package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SOL_10798_STRING {

    // 시간제한 1초 ,  각 줄에는 최대 15개의 글자들이 빈칸 없이 연속으로 주어짐
    // 최악의 경우 15 * 15 회의 연산을 하더라도 넉넉함 -> O(n^2)로도 해결 가능

    // 가로로 입력 , 세로로 읽기
    // row 와 columns의 관계 제대로 이해하기

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
