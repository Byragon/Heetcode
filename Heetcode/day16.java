import java.util.Deque;
import java.util.LinkedList;

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


/**
 * 求左叶子的数量
 */
class Solution16_2 {

    // 层序遍历法
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll(); // 遍历的每个结点
                if (poll.left != null){
                    if (isLeafNode(poll.left)){
                        sum+=poll.left.val;
                    }
                    deque.offer(poll.left);
                }
                if (poll.right != null){
                    deque.offer(poll.right);
                }
            }
        }
        return sum;
    }
    public boolean isLeafNode(TreeNode node){
        if (node == null) {
            return false;
        }
        if (node.right == null && node.left== null) {
            return true;
        }else {
            return false;
        }
    }

    // 递归法
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = 0;
        if (isLeafNode(root.left)){
            left +=  root.left.val;
        }else {
            left += sumOfLeftLeaves2(root.left);
        }
        int right = sumOfLeftLeaves2(root.right);
        return left+right;
    }

    // 前序遍历
    int sum = 0;
    public void getSumLeft(TreeNode node){
        if(node == null){
            return;
        }
        if (isLeafNode(node.left)){
            sum += node.left.val;
        }else {
            getSumLeft(node.left);
        }
        getSumLeft(node.right);
        return;
    }

}
















