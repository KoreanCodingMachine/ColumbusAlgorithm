package stack_queue_linkedlist;

class Node<T> {
    // 1. 노드를 선언
    // 노드란 ? 데이터와 다음 노드를 가리키는 포인터로 이루어진 자료구조

    // 노드를 선언한 이유 -> linkedlist는 노드로 연결된 자료구조

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    private Node<T> head; // 리스트의 첫번째 노드

    public LinkedList() {
        this.head = null;
    }

    public void add(T data) {

    }

    public void remove(T data) {

    }

    
}

public class LinkedListImpl {
    public static void main(String[] args) {

    }
}
