package leetcode.easy;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public IsPalindrome() {
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode node = head;
        List<ListNode> list = new ArrayList<ListNode>();
        do {
            list.add(node);
        } while ((node = node.next) != null);

        int size = list.size();
        for (int i = 0; i <= (size) / 2; i++) {
            if (list.get(i).val != list.get(size - 1 - i).val) return false;
        }
        return true;
    }
}