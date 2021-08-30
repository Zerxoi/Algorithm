package leetcode.problem24;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode ptr = new ListNode();
        ListNode p = head;
        ListNode q = ptr;
        while (p != null) {
            ListNode tmp = p;
            for (int i = 0; i < 2 && p != null; i++) {
                ListNode tmp2 = p.next;
                p.next = q.next;
                q.next = p;
                p = tmp2;
            }
            q = tmp;
        }
        return ptr.next;
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