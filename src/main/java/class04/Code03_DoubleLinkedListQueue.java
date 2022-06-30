package class04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: Code03_DoubleLinkedListQueueAndStack
 * @description: 双链表实现队列和栈
 * @author: m1ria
 * @date: 2022/7/1 3:36
 * @version: 1.0
 */
public class Code03_DoubleLinkedListQueue {

    public static class Node<V> {
        public V value;
        public Node<V> last;
        public Node<V> next;

        public Node(V v){
            value = v;
            last = null;
            next = null;
        }
    }

    public static class MyDeque<V> {
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyDeque() {
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

        public void pushHead(V value) {
            Node<V> cur = new Node<V>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
            size++;
        }

        public void pushTail(V value) {
            Node<V> cur = new Node<V>(value);
            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public V pollHead() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.value;
            if (head == tail) {
                tail = null;
                head = null;
            } else {
                head = head.next;
                head.last = null;
            }
            return ans;
        }

        public V pollTail() {
            V ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = tail.value;
            if (head == tail) {
                tail = null;
                head = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
            return ans;
        }

        public V peekHead() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

        public V peekTail() {
            V ans = null;
            if (tail != null) {
                ans = tail.value;
            }
            return ans;
        }

    }

    public static void testQueue() {
        MyDeque<Integer> myDeque = new MyDeque<>();
        Deque<Integer> test = new ArrayDeque<>();
        int testTime = 10000;
        int maxValue = 20000;
        System.out.println("test start----------");
        for (int i = 0; i < testTime; i++) {
            if (myDeque.isEmpty() != test.isEmpty()) {
                System.out.println("empty ERROR----------");
            }
            if (myDeque.size() != test.size()) {
                System.out.println("size ERROR----------");
            }
            double decide = Math.random();
            if (decide < 0.22) {
                int num = (int) (Math.random() * maxValue);
                myDeque.pushHead(num);
                test.addFirst(num);
            } else if (decide < 0.44) {
                int num = (int) (Math.random() * maxValue);
                myDeque.pushTail(num);
                test.addLast(num);
            } else if (decide < 0.66){
                if (!myDeque.isEmpty()) {
                    int num1 = myDeque.pollHead();
                    int num2 = test.removeFirst();
                    if (num1 != num2) {
                        System.out.println("Error----------");
                    }
                }
            } else if (decide < 0.88) {
                if (!myDeque.isEmpty()) {
                    int num1 = myDeque.pollTail();
                    int num2 = test.removeLast();
                    if (num1 != num2) {
                        System.out.println("Error----------");
                    }
                }
            }else {
                if (!myDeque.isEmpty()) {
                    int num1 = myDeque.peekHead();
                    int num2 = test.peekFirst();
                    int num3 = myDeque.peekTail();
                    int num4 = test.peekLast();
                    if (num1 != num2 && num3 != num4) {
                        System.out.println("Error----------");
                    }
                }
            }
        }
        if (myDeque.size() != test.size()) {
            System.out.println("ERROR----------");
        }
        while (!myDeque.isEmpty()) {
            int num1 = myDeque.pollTail();
            int num2 = test.removeLast();
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
