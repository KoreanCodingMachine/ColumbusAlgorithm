package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int important; // 중요도
    int index; // 순번

    public Point(int important, int index) {
        this.important = important;
        this.index = index;
    }

    public int getImportant() {
        return important;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return important + " , " + index;
    }
}



public class SOL_1966_stack {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(bufferedReader.readLine());

        // 각 문서의 중요도를 체크한다.
        // 중요도가 높은 순으로 정렬한다.

        StringTokenizer stringTokenizer;
        for (int i=0; i < n; i++) {
            Queue<Point> queue = new LinkedList();
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int queue_size = Integer.parseInt(stringTokenizer.nextToken());
            int target_position = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int idx = 0;
            while (stringTokenizer.hasMoreTokens()) {
                queue.add(new Point(Integer.parseInt(stringTokenizer.nextToken()), idx));
                idx++;
            }

            // 1. 큐의 맨 처음 데이터를 확인 poll해서 , 큐가 비어있을때까지 큐 보다 중요도가 큰 값이 있는지 체크
            // 2. 해당 데이터 보다 중요도가 큰 값이 있다면 해당 데이터를 큐의 제일 마지막으로 이동
            // 3. 해당 데이터 보다 중요도가 큰 값이 존재하지 않는다면
            // 4. 중복의 경우를 체크해야 함
            // 5. 중복의 경우가 존재한다면
            // 6. peek할때 순번이 입력받은 순번과 같은지 체크한다.
            // 7. 중복이 없다면 polled한 순번이 입력받은 순번과 같은지 체크하고
            // 8. 같다면 그 순서를 출력해준다.

            int count = 0;
            while (!queue.isEmpty()) {
                boolean hasImportant = false;
                Point polled = queue.poll();



                // 큐 에서 높은 우선순위가 있는지 체크
                for (Point point : queue) {
                    if (point.getImportant() > polled.getImportant()) {
                        hasImportant = true;
                        break;
                    }
                }

                if (hasImportant) {
                    // 큐 안에 높은 우선순위가 있는 경우
                    queue.add(polled);
                } else {
                    // 큐 안에 높은 우선순위가 없는 경우
                    count++; // 출력 순번 + 1
                    if (polled.getIndex() == target_position) {
                        // 입력받은 순번과 , 뽑아낸 순번이 같으면 braek;
                        break;
                    }
                }

            }
            stringBuilder.append(count).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
