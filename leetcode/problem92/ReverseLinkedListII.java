package leetcode.problem92;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ReverseLinkedListII().reverseBetween(ListNode.build(new int[] { 1, 2, 3, 4, 5 }), 2, 4);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 确定 left 左边的节点 s
        ListNode s = dummy;
        int i = 1;
        while (s.next != null && i < left) {
            s = s.next;
            i++;
        }

        // 确定 right 右边的节点 t
        ListNode t = s.next;
        while (t != null && i < right) {
            t = t.next;
            i++;
        }
        ListNode p = t;
        t = t.next;
        p.next = null;

        // p 从第 left 个节点开始遍历到第 right-1 个节点
        p = s.next;
        while (p.next != null) {
            ListNode tmp = p.next;
            p.next = t;
            t = p;
            p = tmp;
        }
        // 第 right 个节点连接 s 和 t
        s.next = p;
        p.next = t;
        return dummy.next;
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

    public static ListNode build(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < len; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head;
    }
}