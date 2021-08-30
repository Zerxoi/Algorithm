package lcof.problem14;

public class OptimalSolution {
    
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode iNode = head;
        ListNode jNode = head;
        while (k > 0) {
            if (jNode == null)
                return null;
            jNode = jNode.next;
            k--;
        }
        while (jNode != null) {
            iNode = iNode.next;
            jNode = jNode.next;
        }
        return iNode;
    }
}
