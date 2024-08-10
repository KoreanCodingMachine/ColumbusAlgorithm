package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SOL_1316_ALPHABET {
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
