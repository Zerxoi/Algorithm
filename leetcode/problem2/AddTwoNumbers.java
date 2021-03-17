package leetcode.problem2;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        boolean flag = false;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            if (flag) {
                sum++;
                flag = false;
            }
            if (sum > 9) {
                p.next = new ListNode(sum - 10);
                flag = true;
            } else {
                p.next = new ListNode(sum);
            }
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (flag) {
            p.next = new ListNode(1);
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
