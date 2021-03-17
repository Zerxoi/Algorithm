package JZOffer.JZ15;

// 创建头节点
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        while (head.next != null) {
            ListNode t = head.next;
            head.next = t.next;
            t.next = tmp.next;
            tmp.next = t;
        }
        return tmp.next;
    }
}