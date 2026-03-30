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
    boolean isValid = true;
    int min = -1001;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return isValid;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;}
        inorder(root.left);
        if(root.val <= min){
            isValid = false;
            return;
        }
        min = root.val;
        inorder(root.right);



    }
}
