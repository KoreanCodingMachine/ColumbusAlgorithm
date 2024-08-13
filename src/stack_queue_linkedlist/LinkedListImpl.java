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
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove(T data) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        // 첫번째 노드가 삭제하려는 노드인지 확인
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        // 리스트를 순회하며 삭제하려는 데이터 조회
        // 다음 노드가 비어있지 않고 && 다음노드의 데이터가 삭제하려는 데이터와 같지 않다면
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next == null) {
            // 노드의 끝까지 순회했지만 , 삭제하려는 데이터가 없음
            System.out.println("element not found");
        } else {
            // current.next를 노드에서 제거 , 다음 노드로 연결
            current.next = current.next.next;
        }

    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // 리스트의 첫 번째 노드의 데이터를 반환하는 메소드 (제거하지 않음)
    public T peek() {
        if (head == null) {
            System.out.println("List is empty. Cannot peek.");
            return null;
        }
        return head.data;
    }


}

public class LinkedListImpl {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.print("LinkedList: ");
        list.printList(); // 10 -> 20 -> 30 -> null

        System.out.println("Peek: " + list.peek()); // 10
        System.out.println("Size: " + list.size()); // 3

        list.remove(20);
        System.out.print("After removing 20: ");
        list.printList(); // 10 -> 30 -> null

        list.remove(40); // Element not found.
    }
}
