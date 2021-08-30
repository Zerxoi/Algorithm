package ot;

import java.util.Scanner;

public class MayiSolution1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        // 构建树
        TreeNode root = new TreeNode(input.nextInt());
        for (int i = 0; i < n - 1; i++) {
            int v = input.nextInt();
            TreeNode node = root;
            while (node != null) {
                if (node.val > v) {
                    if (node.left == null) {
                        node.left = new TreeNode(v);
                        break;
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new TreeNode(v);
                        break;
                    }
                    node = node.right;
                }
            }
        }
        input.close();

        // 分别求出左右支
        int[] res = dfs(root);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] res = new int[2];
        TreeNode tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
            res[0]++;
        }
        tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
            res[1]++;
        }
        int[] res1 = dfs(root.left);
        int[] res2 = dfs(root.right);
        if (res1 != null) {
            res[0] = res1[0] > res[0] ? res1[0] : res[0];
            res[1] = res1[1] > res[1] ? res1[1] : res[1];
        }
        if (res2 != null) {
            res[0] = res2[0] > res[0] ? res2[0] : res[0];
            res[1] = res2[1] > res[1] ? res2[1] : res[1];
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    // 测试前序遍历
    // public static void preorder(TreeNode root) {
    // if (root == null) {
    // return;
    // }
    // preorder(root.left);
    // System.out.println(root.val);
    // preorder(root.right);
    // }
}
