public class day16 {


}

/**
 * Definition for a binary tree node. 已经在其他分支中定义了
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 判断是否为平衡二叉树，左右子树的高度差得获取
 */


class Solution16_1 {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        getHeigt(root);
        return flag;
    }

    public int getHeigt(TreeNode root){
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null){ //叶子结点
            return 1;
        }
        // 获取左子树的高度
        int leftheight = getHeigt(root.left);
        // 获取右子树的高度
        int rightheight = getHeigt(root.right);
        if (Math.abs(leftheight-rightheight)>1) {
            this.flag = false;
        }
        int myheight = Math.max(leftheight,rightheight);
        return myheight + 1;
    }
}