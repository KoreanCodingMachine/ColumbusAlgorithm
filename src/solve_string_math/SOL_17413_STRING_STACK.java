package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SOL_17413_STRING_STACK {

    // 시간 제한 1초 , 문자열 최대 길이 100000 -> O(n^2) 연산으로 해결 불가

    // 스택 자료구조를 활용해 태그가 아닌 문자열을 공백을 기준으로
    // 스택에 push
    // 공백을 만나거나 || 태그를 만나면 pop
    // 자동으로 뒤집어진 문자열 반환

    // 공백 x , 태그 x
    // 스택을 pop할 조건이 없음으로 , 출력 전 최종 스택이 비어있는지 확인


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        // 1. 스택을 이용하여 단어를 뒤집는다.
        // 2. < > 태그는 뒤집지 않는다.
        // 3. 단어는 공백을 기준으로 함으로 공백 별로 뒤집어야 한다. (단어의 경우)


        // 1. 스택 선언
        Stack<Character> stack = new Stack<>();

        // 2.문자열 입력 받음
        String str = bufferedReader.readLine();

        // 3.태그인지 아닌지 구별하기 위해 플래그 변수 설정
        boolean tag = false;

        // 문자열을 순회하면서 태그인지 아닌지 구분한다.
        for (int i=0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                tag = true;
                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.pop());
                }
                stringBuilder.append(str.charAt(i));
                continue;
            } else if (str.charAt(i) == '>') {
                tag = false;
                stringBuilder.append(str.charAt(i));
                continue;
            }

            if (!tag) {
                if (str.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        stringBuilder.append(stack.pop());
                    }
                    stringBuilder.append(' ');
                } else if (str.charAt(i) != ' '){
                    stack.push(str.charAt(i));
                }
            } else {
                // tag
                stringBuilder.append(str.charAt(i));
            }

        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        System.out.println(stringBuilder);
    }
}
