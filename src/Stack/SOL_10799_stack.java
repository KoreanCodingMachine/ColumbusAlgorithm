package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SOL_10799_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();

        Stack<Character> stack = new Stack<>();

        int count = 0;

        // () -> 레이저 , 여는괄호 , 닫는 괄호가 쌍으로 나오면
        // 레이저 -> 스택에 남아있는 수
        // 레이저가 아니면 -> 스택에서 pop +1

        char ch[] = str.toCharArray();
        boolean laser = false;

        for (int i=0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(ch[i]);
            } else {
                stack.pop();
                if (ch[i-1] == '(') {
                    laser = true;
                } else {
                    count++;
                }
            }

            if (laser) {
                count += stack.size();
                laser = false;
            }
        }

        System.out.println(count);
    }
}
