package solve_string_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// 시간초과 난 코드
public class SOL_20291_2_STRING_TIME_ERROR {

    // 스택에 push하는 연산의 경우 o(1)의 시간복잡도를 가지지만
    // extend 배열과 , stack에서 contains 메서드를 활용해
    // 총 2중 for문을 도는것과 같은 원리로 동작함으로 O(n^2)의 시간복잡도를 가지게 된다.

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());

        String extend[] = new String[n];

        String arr[];
        for (int i=0; i < n; i++) {
            arr = bufferedReader.readLine().split("\\.");
            extend[i] = arr[1];
        }

        Stack<String> stack = new Stack<>();

        // 1.확장자 이름이 중복되었는지 여부 체크
        boolean duplicate = false;

        for (int i=0; i < extend.length; i++) {
            if (!stack.contains(extend[i])) { // 시간 초과 발생
                stack.push(extend[i]);
            } else {
                duplicate = true;
                break;
            }
        }

        stack.clear();

        // 1-1. 중복되었다면 사전순으로 나열
        // 1-2. 중복되지 않았다면 그냥 순서대로 출력
        if (duplicate) {
            Arrays.sort(extend); // 기본적으로 정렬하면 사전순으로 나열한다.

            int count = 1;
            String target = extend[0];
            stack.push(target);

            for (int i=1; i < extend.length; i++) {
                // 시간 복잡도가 발생한 부분
                if (stack.contains(extend[i])) {
                    count++;
                } else {
                    stringBuilder.append(stack.pop()).append(" ").append(count).append("\n");
                    stack.push(extend[i]);
                    count = 1;
                }
            }

            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop()).append(" ").append(count).append("\n");
            }

        } else {
            for (String str : extend) {
                stringBuilder.append(str).append(" ").append(1).append("\n");
            }
        }

        // 개수 저장 및 출력


        System.out.println(stringBuilder);
    }
}
