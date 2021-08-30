package datastruct.tree;

public class TreeNode {
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

    public static TreeNode buildTreeNode(Integer[] vals) {
        int len = vals.length;
        if (len == 0) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            if (vals[i] != null) {
                nodes[i] = new TreeNode(vals[i]);
            }
        }
        for (int i = 0; i < len; i++) {
            TreeNode node = nodes[i];
            if (node != null) {
                if (2 * i + 1 < len) {
                    node.left = nodes[2 * i + 1];
                }
                if (2 * i + 2 < len) {
                    node.right = nodes[2 * i + 2];
                }
            }
        }
        return nodes[0];
    }
}
