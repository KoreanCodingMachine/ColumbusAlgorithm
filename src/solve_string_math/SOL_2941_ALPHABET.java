package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SOL_2941_ALPHABET {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        String str = bufferedReader.readLine();

        int count = 0;
        // c , s , z 로 시작할때
        // 뒤에 단어가 = , - 이면 크로아티아 알파벳

        // l , n  일때
        // 뒤에 단어가 j 이면 크로아티아 알파벳

        // d 일때
        // 뒤에 단어가 - 이면 크로아티아 알파벳
        // 뒤에 단어가 z 이면 그 뒤에 단어가 = 이면 크로아티아 알파벳

        for (int i=0; i < str.length(); i++) {
            char word = str.charAt(i);
            boolean croatian = false;

            if (word == 'c' || word == 's' || word == 'z') {
                if (i < str.length()-1) {
                    // 마지막 문자가 아니라면
                    // 마지막 문자일때는 다음 문자가 없음으로
                    if (str.charAt(i+1) == '=' || str.charAt(i+1) == '-') {
                        count++;
                        i++;
                        croatian = true;
                    }
                }
            } else if (word == 'l' || word == 'n') {
                if (i < str.length()-1) {
                    if (str.charAt(i+1) == 'j') {
                        count++;
                        i++;
                        croatian = true;
                    }
                }
            }else if (word == 'd') {
                if (i < str.length()-1) {
                    if (str.charAt(i+1) == '-') {
                        count++;
                        i++;
                        croatian = true;
                    }
                }

                if (i < str.length()-2) {
                    if (str.charAt(i+1) == 'z') {
                        if (str.charAt(i+2) == '=') {
                            count++;
                            i+=2;
                            croatian = true;
                        }
                    }
                }

            }

            if (!croatian) {
                count++;
            }


        }

        stringBuilder.append(count);
        System.out.println(stringBuilder);

    }
}
