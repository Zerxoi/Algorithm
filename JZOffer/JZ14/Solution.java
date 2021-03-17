package JZOffer.JZ14;

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }
        if (k > n) {
            return null;
        }
        node = head;
        for (int i = 0; i < n-k; i++) {
            node = node.next;
        }
        return node;
    }
}
