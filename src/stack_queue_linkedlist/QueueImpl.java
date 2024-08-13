package stack_queue_linkedlist;

import java.util.LinkedList;

class Queue<T> {

    // 큐는 FIFO 형태의 자료구조

    private LinkedList<T> linkedList = new LinkedList<>();

    // 큐에 삽입
    public void enqueue(T value) {
        linkedList.add(value);
    }

    // 큐에 삭제
    // 맨 처음 삽입된 요소가 삭제되어야 함 -> removeFirst
    public T dequeue() {
        if (!isEmpty()) {
            return linkedList.removeFirst();
        } else {
            System.out.println("queue is empty");
            return null;
        }
    }

    // 맨 처음 요소 확인 -> getFirst , 확인만 하는것 , 삭제는 x
    public T peek() {
        if (!isEmpty()) {
            return linkedList.getFirst();
        } else {
            System.out.println("queue is empty");
            return null;
        }
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int size() {
        return linkedList.size();
    }

}

public class QueueImpl {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Peek: " + queue.peek()); // 10
        System.out.println("Dequeue: " + queue.dequeue()); // 10
        System.out.println("Peek: " + queue.peek()); // 20

        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.dequeue()); // 30
        System.out.println(queue.dequeue()); // null
    }
}
