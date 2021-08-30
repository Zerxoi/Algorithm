package datastruct.tree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeNode(new Integer[] { 1, 2, null, 4, 5, null, null, 8, 9 });
        postorder(root);
    }

    public static void inorder(TreeNode root) {
        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode q = stack.pop();
                System.out.println(q.val);
                p = q.right;
            }
        }
    }

    public static void preorder(TreeNode root) {
        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                System.out.println(p.val);
                if (p.right != null) {
                    stack.push(p.right);
                }
                p = p.left;
            } else {
                p = stack.pop();
            }
        }
    }

    // public static void postorder(TreeNode root) {
    // TreeNode p = root;
    // TreeNode pre = null;
    // Deque<TreeNode> stack = new LinkedList<>();
    // while (p != null || !stack.isEmpty()) {
    // if (p != null) {
    // stack.push(p);
    // p = p.left;
    // } else {
    // TreeNode q = stack.peek(); // p == null 还要根据 q.right 来判断是否弹出，如果 right == null
    // 或者 right == pre（上一个弹出的元素） 则弹出
    // if (q.right == null || q.right == pre) {
    // System.out.println(q.val);
    // pre = stack.pop();
    // p = null; // 下次直接弹出栈中的元素
    // } else {
    // p = q.right;
    // }
    // }
    // }
    // }

    public static void postorder(TreeNode root) {
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left == null && peek.right == null || pre != null && (peek.right == pre || peek.left == pre)) {
                System.out.println(peek.val);
                pre = stack.pop();
            } else {
                if (peek.right != null) {
                    stack.push(peek.right);
                }
                if (peek.left != null) {
                    stack.push(peek.left);
                }
            }
        }
    }
}
