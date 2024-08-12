package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SOL_9012_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());
        String input = "";

        Stack<Character> stack = new Stack<>();

        // (((())))
        // ())(()

        // 스택에서 괄호를 제거하고 가장 위의 원소가 ( 괄호이면 닫힐 수가 없음 -> NO

        for (int i=0; i < n; i++) {
            input = bufferedReader.readLine();

            char ch[] = input.toCharArray();
            int cnt = 0;
            boolean err = false;

            for (int j=0; j < ch.length; j++) {
                if (ch[j] == '(') {
                    stack.push(ch[j]);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        err = true;
                        stringBuilder.append("NO\n");
                        break;
                    }
                }
            }

            if (!err) {
                if (stack.isEmpty()) {
                    stringBuilder.append("YES\n");
                } else {
                    stringBuilder.append("NO\n");
                }
            }

            stack.clear();
        }


        System.out.println(stringBuilder);
    }

}
