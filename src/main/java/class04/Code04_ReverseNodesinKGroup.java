package class04;

import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

/**
 * @className: Code04_ReverseNodesinKGroup
 * @description: K个节点组 内逆序调整
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @author: m1ria
 * @date: 2022/7/1 4:10
 * @version: 1.0
 */
public class Code04_ReverseNodesinKGroup {

    public static class ListNode {
        public int val;
        public ListNode next;

    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, head);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    private static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    private static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

}




