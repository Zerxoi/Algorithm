package lcof.problem03;

import java.util.ArrayList;

public class RecusionSolution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        recursion(listNode, list);
        return list;
    }

    public void recursion(ListNode listNode, ArrayList<Integer> list) {
        if (listNode == null)
            return;
        recursion(listNode.next, list);
        list.add(listNode.val);
    }
}