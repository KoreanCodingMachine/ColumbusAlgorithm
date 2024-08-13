package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SOL_18258_queue {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        // 링크드 리스트를 선언한다.
        LinkedList<Integer> linkedList = new LinkedList<>();


        // Arraylist 와 LinkedList의 차이에 대해 알고 쓰자
        // Queue 는 선입 선출의 자료구조
        // 먼저 들어온 자료가 먼저 나오게 된다.

        // push -> add()
        // pop -> removeFirst()
        // size -> size
        // empty -> isempty
        // front -> getFirst()
        // back -> getLast()

        // linkedList의 최대 연산은 O(N)임으로 문제 조건 만족

        for (int i=0; i < n; i++) {
            String str = bufferedReader.readLine();

            if (str.startsWith("push")) {
                String arr[] = str.split(" ");
                push(Integer.parseInt(arr[1]), linkedList);
            }else if (str.equals("pop")) {
                stringBuilder.append(pop(linkedList)).append("\n");
            }else if (str.equals("size")) {
                stringBuilder.append(size(linkedList)).append("\n");
            }else if (str.equals("empty")) {
                stringBuilder.append(empty(linkedList)).append("\n");
            }else if (str.equals("front")) {
                stringBuilder.append(front(linkedList)).append("\n");
            }else if (str.equals("back")) {
                stringBuilder.append(back(linkedList)).append("\n");
            }

        }

        System.out.println(stringBuilder);


    }
    public static void push(int x, LinkedList<Integer> linkedList) {
        linkedList.add(x);
    }

    public static int pop(LinkedList<Integer> linkedList) {
        if (!linkedList.isEmpty()) {
            return linkedList.removeFirst();
        }

        return -1;
    }

    public static int size(LinkedList<Integer> linkedList) {
        return linkedList.size();
    }

    public static int empty(LinkedList<Integer> linkedList) {
        if (!linkedList.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public static int front(LinkedList<Integer> linkedList) {
        if (!linkedList.isEmpty()) {
            return linkedList.getFirst();
        }
        return -1;
    }

    public static int back(LinkedList<Integer> linkedList) {
        if (!linkedList.isEmpty()) {
            return linkedList.getLast();
        }
        return -1;
    }
}
