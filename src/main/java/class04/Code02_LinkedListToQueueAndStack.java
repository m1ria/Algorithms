package class04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: Code02_LinkedListToQueueAndStack
 * @description: TODO
 * @author: m1ria
 * @date: 2022/6/27 23:23
 * @version: 1.0
 */
public class Code02_LinkedListToQueueAndStack {

    public static class Node<V>{
        public V value;
        public Node<V> next;

        public Node(V v) {
            value = v;
            next = null;
        }
    }

    public static class MyQueue<V>{
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }
        public int size() {
            return size;
        }
        public boolean isEmpty() {
            return size == 0;
        }

        public void offer(V value) {
            Node<V> cur = new Node<V>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public V poll() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return ans;
        }

        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }
    }

    public static void testQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> test = new LinkedList<>();
        int testTime = 10000;
        int maxValue = 20000;
        System.out.println("test start----------");
        for (int i = 0; i < testTime; i++) {
            if (myQueue.isEmpty() != test.isEmpty()) {
                System.out.println("empty ERROR----------");
            }
            if (myQueue.size() != test.size()) {
                System.out.println("size ERROR----------");
            }
            double decide = Math.random();
            if (decide < 0.33) {
                int num = (int) (Math.random() * maxValue);
                myQueue.offer(num);
                test.offer(num);
            } else if (decide < 0.66) {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.poll();
                    int num2 = test.poll();
                    if (num1 != num2) {
                        System.out.println("Error----------");
                    }
                }
            } else {
                if (!myQueue.isEmpty()) {
                    int num1 = myQueue.peek();
                    int num2 = test.peek();
                    if (num1 != num2) {
                        System.out.println("Error----------");
                    }
                }
            }
        }
        if (myQueue.size() != test.size()) {
            System.out.println("ERROR----------");
        }
        while (!myQueue.isEmpty()) {
            int num1 = myQueue.poll();
            int num2 = test.poll();
            if (num1 != num2) {
                System.out.println("Error----------");
            }
        }
        System.out.println("test end------------");
    }

    public static void main(String[] args) {
        testQueue();
    }
}
