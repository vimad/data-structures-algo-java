package leetcode.easy;

import leetcode.ListNode;

public class RemoveElements {
    public RemoveElements() {
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        while (node != null) {
            if (node == head && node.val == val) {
                head = node.next;
            } else {
                ListNode temp = node.next;
                while (temp != null && temp.val == val) {
                    node.next = temp.next;
                    temp = temp.next;
                }
            }
            node = node.next;
        }
        return head;
    }
}