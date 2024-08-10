package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SOL_9996_STRING {

    // 문자열의 최대 길이 100 , 제한시간 1초
    // 시간 복잡도 크게 고려 x

    // 이 문제는 반례를 찾는게 중요한문제였음
    // 특정 문자열이 특정 패턴에 맞는지 찾는 문제

    // 만약 특정 문자열을 분리한후 해당 패턴으로 시작 , 종료하는지만 검증한다면
    // 아래의 반례 케이스에서 걸릴것

    // aaa*a
    // aaa

    // a*a
    // a





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String target = br.readLine(); //"aa*bb"

        String[] str = target.split("\\*"); //문자열 나누기 -> String[] str = {"aa","bb"};
        StringBuilder sb = new StringBuilder(); //정답
        for(int i=0; i<n; i++) {
            String word = br.readLine(); //탐색할 문자
            String start = word.substring(0, str[0].length()); //word앞에 문자열
            String end = word.substring(word.length()-str[1].length()); //word뒤에 문자열

            if(word.length()<target.length()-1) {
                sb.append("NE").append("\n");
                continue;
            }

            if(start.equals(str[0]) && end.equals(str[1])) sb.append("DA").append("\n");//만들수있음.
            else sb.append("NE").append("\n");//못만듦.
        }

        System.out.println(sb.toString());
    }
}
