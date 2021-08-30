package leetcode.problem872;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        System.out.println(new LeafSimilarTrees().leafSimilar(TreeNode.build(new Integer[] { 1, 2, 3 }),
                TreeNode.build(new Integer[] { 1, 3, 2 })));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = inorder(root1, new ArrayList<>());
        List<Integer> list2 = inorder(root2, new ArrayList<>());
        if (list1.size() == list2.size()) {
            int size = list1.size();
            for (int i = 0; i < size; i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inorder(root.left, list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        inorder(root.right, list);
        return list;
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

    public static TreeNode build(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        TreeNode[] nodes = new TreeNode[len];
        nodes[0] = new TreeNode(nums[0]);
        for (int i = 1; i < len; i++) {
            if (nums[i] == null) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(nums[i]);
            }
            int parent = (i + 1) / 2;
            if (i + 1 == 2 * parent) {
                nodes[parent - 1].left = nodes[i];
            } else {
                nodes[parent - 1].right = nodes[i];
            }
        }
        return nodes[0];
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}