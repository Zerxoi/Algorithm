package leetcode.problem23;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        } else if (i > j) {
            return null;
        }
        int mid = ((j - i) >> 1) + i;
        return mergeTwoLists(merge(lists, i, mid), merge(lists, mid + 1, j));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tmp = head;
        while (list1 != null && list2 != null) {
            if (list2.val < list1.val) {
                tmp.next = list2;
                list2 = list2.next;
            } else {
                tmp.next = list1;
                list1 = list1.next;
            }
            tmp = tmp.next;
        }
        tmp.next = list1 != null ? list1 : list2;
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
}