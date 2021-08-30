package leetcode.problem783;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumDistanceBetweenBstNodes {
    // 非递归前序遍历
    public int minDiffInBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        TreeNode p = root;
        int res = Integer.MAX_VALUE;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode q = stack.pop();
                if (pre != null) {
                    res = Math.min(res, q.val - pre.val);
                }
                pre = q;
                p = q.right;
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
