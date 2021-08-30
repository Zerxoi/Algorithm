package lcof.problem15;

public class OptimalSolution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next =head;
            head = node;
            node = tmp;
        }
        return head;
    }
}
