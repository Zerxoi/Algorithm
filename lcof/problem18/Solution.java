package lcof.problem18;

import java.util.Stack;

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

    // 非递归前序遍历I
    public void iterMirrorI(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root == null) {
                root = stack.pop();
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.right != null)
                stack.push(root.right);
            root = root.left;
        }
    }

    // 非递归前序遍历2
    public void iterMirrorII(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return;
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
    }

    // 非递归层次遍历
    public void iterMirrorIII(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            TreeNode tmpNode = node.left;
            node.left = node.right;
            node.right = tmpNode;
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
    }
}