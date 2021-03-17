package JZOffer.JZ04;

public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return rec(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode rec(int[] pre, int pre_left, int pre_right, int[] in, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[pre_left]);
        int i = in_left;
        while (in[i] != pre[pre_left]) {
            i++;
        }
        treeNode.left = rec(pre, pre_left + 1, pre_left + i - in_left, in, in_left, i - 1);
        treeNode.right = rec(pre, pre_left + i - in_left + 1, pre_right, in, i + 1, in_right);
        return treeNode;
    }
}