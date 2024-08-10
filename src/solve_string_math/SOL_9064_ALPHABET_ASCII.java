package solve_string_math;


import java.io.*;

public class SOL_9064_ALPHABET_ASCII {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 총 test_case 기간 동안
        String input = ""; // 문자열

        int test_case = Integer.parseInt(bufferedReader.readLine());

        StringBuilder result = new StringBuilder();

        for (int i=0; i < test_case; i++) {
            input = bufferedReader.readLine();

            int max = 0; // 최대 값
            int count = 0; // 최대 값 중복 횟수
            int idx = 0; // 최대 값의 인덱스 번호

            // 알파벳 소문자는 'a' ~ 'z' 까지 총 26개 있음
            int alphabet[] = new int[26];

            // 문자열의 공백 제거
            char ch[] = input.replaceAll("\\s+","").toCharArray(); // 공백을 제거한 char형 배열로 변환

            // 알파벳 소문자의 아스키 코드는 97이다.
            // 97 - 97 = 0 -> 0 번째 인덱스

            for (int j=0; j < ch.length; j++) {
                alphabet[ch[j] - 'a']++;
            }

            // 최대 값 구하기
            for (int j=0; j < alphabet.length; j++)  {
                if (alphabet[j] > max) {
                    max = alphabet[j];
                    idx = j;
                }
            }

            // 최대 빈도 구하기
            for (int j=0; j < alphabet.length; j++) {
                if (alphabet[j] == max) {
                    count++;
                }
            }

            if (count > 1) {
                result.append("?").append("\n");
            } else {
                result.append((char) (idx + 'a')).append("\n");
            }

        }

        System.out.print(result.toString());
    }
}
