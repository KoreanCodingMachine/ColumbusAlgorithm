package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SOL_1918_stack_re {
    public static void main(String[] args) throws IOException {
        // 중위 표기식 -> 후위 표기식

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        String expression = bufferedReader.readLine();
        Stack<Character> stack = new Stack<>();


        // 연산자 우선순위
        // () , * / , + -



        // A*(B+C) ABC+*

        // 다른 사람의 접근방식 참고

        // 차량 기지 알고리즘
        //숫자가 들어오면 그대로 출력한다.
        //여는 괄호가 나오면 스텍에 넣음
        //닫는 괄호가 나오면 여는 괄호를 스텍에서 만날때 까지 모두 pop해서 출력함(여는괄호는 pop)
        //괄호가 아닌 연산자가 스텍에 들어왔을 때,
        // 넣으려는 연산자보다 우선순위가 높거나 같은 연산자가 이미 있다면 없을때 까지 모두 pop해서 출력함 모두 출력후에 넣으려는 연산자 push!
        //스텍에 남은 연산자 pop해서 출력


        // 일단 구현은 직접 해보자
        for (int i=0; i < expression.length(); i++) {
           char temp = expression.charAt(i);

           if (temp >= 'A'&& temp <= 'Z') {
               stringBuilder.append(temp);
           } else if (temp == '(') {
               stack.push(temp);
           } else if (temp == ')') {
               while (!stack.isEmpty() && stack.peek() != '(') {
                   stringBuilder.append(stack.pop());
               }
               stack.pop();
           } else {
               // 여는괄호 , 닫는 괄호도 아닌 연산자
               while (!stack.isEmpty() && priority(stack.peek()) >= priority(temp)) {
                   // stack에 push 하려는 연산자보다 , 현재 스택에 우선순위가 더 큰 연산자가 있다면
                   stringBuilder.append(stack.pop());
               }
               stack.push(temp);
           }

        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }


        System.out.println(stringBuilder);
    }
    public static int priority(char temp) {
        if (temp == '(') return 0;
        if (temp == '+' || temp == '-') return 1;
        else return 2;
    }
}
