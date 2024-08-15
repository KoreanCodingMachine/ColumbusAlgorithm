package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SOL_1935_stack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        String expression = bufferedReader.readLine();
        int data[] = new int[n];

        for (int i=0; i < n; i++) {
            data[i] = Integer.parseInt(bufferedReader.readLine());
        }


        // ABC*+DE/-
        // (A + B*C) - (D/E)

        // 스택에 숫자를 넣고 연산자를 만나면 pop한다고 가정해보자

        // A B C , * -> B*C -> 다시 스택에 넣음
        // A , B*C , + -> A + (B*C) -> 다시 스택에 넣음
        // (A + (B*C)) , D E , / -> D / E -> 스택
        // 최종 결과

        // AA+A+
        // AA+ -> AA
        // AA A + -> AAA

        // 연산자인지 판별
        // 연산자 -> + , - , * , / , % 까지로 생각


        Stack<Double> stack = new Stack<>();

        for (int i=0; i < expression.length(); i++) {
            if (!isOperator(expression.charAt(i))) {
                stack.push((double) data[expression.charAt(i)-'A']);
            } else {
                // 수식이면
                Double pop1 = stack.pop();
                Double pop2 = stack.pop();

                double value = 0.00;
                if (expression.charAt(i) == '+') {
                    value = pop2 + pop1;
                } else if (expression.charAt(i) == '-') {
                    value = pop2 - pop1;
                } else if (expression.charAt(i) == '*') {
                    value = pop2 * pop1;
                } else if (expression.charAt(i) == '/') {
                    value = pop2 / pop1;
                } else if (expression.charAt(i) == '%') {
                    value = pop2 % pop1;
                }
                stack.push(value);
            }
        }

        // 최종적으로 스택에 한개의 데이터가 남아있음
        System.out.println(String.format("%.2f",stack.pop()));

    }


    public static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c =='*' || c == '/' || c == '%') {
            return true;
        }

        return false;
    }

}
