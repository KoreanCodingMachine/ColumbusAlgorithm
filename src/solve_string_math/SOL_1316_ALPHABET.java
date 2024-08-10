package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SOL_1316_ALPHABET {

    // 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
    // 둘째 줄부터 N개의 줄에 단어가 들어온다.
    // 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

    // 시간 제한 2초 , O(n^2)로도 해결 가능

    // 연속된 문자열에서 알파벳 순서와 상관 없이 문자가 연속적으로 나와야 함
    // 이미 한번 나왔던 문자는 다시 나올 수 없음

    // 알파벳 소문자는 총 26개 (a ~ z)
    // alpha[] -> 이미 나왔던 문자인지 체크

    // char 타입은 + - 연산시 ascii코드 값 기준으로 하기 때문에
    // 활용 가능
    // 'b' - 'a' = 1 , 'a' - 'a' = 0



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int count = n;

        String str = "";

        for (int i=0; i < n; i++) {
            str = bufferedReader.readLine();
            boolean alpha[] = new boolean[26];
            char ch[];
            ch = str.toCharArray();
            alpha[ch[0]-'a'] = true; // 맨 처음 알파벳

            for (int j=1; j < ch.length; j++) {
                // 이전 문자와 다르고
                if (ch[j] != ch[j-1]){
                    // 이전에 나왔던 문자가 아니라면
                    if (!alpha[ch[j]-'a']) {
                        alpha[ch[j]-'a'] = true;
                    } else {
                        count--;
                        break;
                    }
                }
            }
        }

        System.out.println(count);

    }
}
