import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class day15 {
}


class Solution151{
    public int maxDepth(TreeNode root) {
        int depth = 0;
        return getDepth(root,depth);
    }
    public int getDepth(TreeNode root,int depth){
        if(root == null){
            return depth;
        }
        // 否则深度为当前深度+左子树/右子树大的那个  +1（别弄错了）
        int leftDepth = getDepth(root.left,depth);
        int rightDepth = getDepth(root.right,depth);
        depth = leftDepth>=rightDepth?leftDepth+1:rightDepth+1;
        return depth;
    }

    // 试一下层序遍历的方法
    public int maxDepth2(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        int depth = 0; int size = 0;
        if (root == null) {
            return depth;
        }
        deque.push(root); size = 1;
        while (!deque.isEmpty()){
            depth+=1;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if(node.left!=null){
                    deque.offer(node.left);
                }
                if(node.right!=null){
                    deque.offer(node.right);
                }
            }
            size = deque.size();
        }
        return depth;
    }

}
class Solution152{
    public int minDepth(TreeNode root) {
        if(root.right == null && root.left == null){
            return 1;
        }else if(root.right == null){
            return minDepth(root.left)+1;
        }else if(root.left == null){
            return minDepth(root.right)+1;
        }else {
            return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
        }
    }
//    int min = 0;
    public int minDepth2(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        int depth = 0; int size = 0;
        if (root == null) {
            return depth;
        }
        deque.push(root); size = 1;
        // 开始迭代
        while (!deque.isEmpty()){
            depth+=1;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left == null && node.right ==null){
                    return depth;
                }
                if(node.left!=null){
                    deque.offer(node.left);
                }
                if(node.right!=null){
                    deque.offer(node.right);
                }

            }
            size = deque.size();
        }
        return depth;
    }

}

class Solution153{
    public int minDepth(TreeNode root) {
        if(root.right == null && root.left == null){
            return 1;
        }else if(root.right == null){
            return minDepth(root.left)+1;
        }else if(root.left == null){
            return minDepth(root.right)+1;
        }else {
            return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
        }
    }
    //    int min = 0;
    public int numNode(TreeNode root){
        int num = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        int depth = 0; int size = 0;
        if (root == null) {
            return num;
        }
        deque.push(root); size = 1;
        num+=1;
        // 开始迭代
        while (!deque.isEmpty()){
            depth+=1;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                num+=1;
                if(node.left!=null){
                    deque.offer(node.left);
                }
                if(node.right!=null){
                    deque.offer(node.right);
                }
            }
            size = deque.size();
        }
        return num;
    }

}