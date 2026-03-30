/**
 * Definition for a binary tree node.
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

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left==null && root.right == null)){
            return true;
        }
        else{
            if(root.right==null){
                return root.left.left == null && root.left.right == null;
            }
            else if(root.left == null){
                return root.right.left == null && root.right.right == null;
            }
            else{
            return Math.abs(getHeight(root.right) - getHeight(root.left)) <= 1 && isBalanced(root.right) && isBalanced(root.left);}
        }
    }

    private static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        else{
            return 1+Math.max(getHeight(root.left),getHeight(root.right));
        }
    }
}
