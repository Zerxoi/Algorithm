package leetcode.problem61;

public class RotateList {
    public static void main(String[] args) {
        ListNode list = new RotateList().rotateRight(ListNode.build(new int[] { 1, 2, 3, 4, 5, 6 }), 2);
        while (list != null) {
            System.out.print(list.val + "\t");
            list = list.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        // 链表为空或者只有一个节点或者k为零直接返回 head
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        int len = 0;
        while (p != null && len < k) { // p 比 q 领先 k 个节点，如果超出长度记录链表长度为 len
            p = p.next;
            len++;
        }
        if (p == null) { // 表示 k 大于等于 len
            if (len == k) { // 如果 k == len 直接返回 head
                return head;
            }
            k = k % len; // 计算余数
            p = head; // 重新定位 p 节点
            for (int i = 0; i < k; i++) {
                p = p.next;
            }
        }
        while (p.next != null) { // p 和 q 同时右移动，直到 p 到链表末尾
            p = p.next;
            q = q.next;
        }
        // 链表旋转
        p.next = head;
        head = q.next;
        q.next = null;
        return head;
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
