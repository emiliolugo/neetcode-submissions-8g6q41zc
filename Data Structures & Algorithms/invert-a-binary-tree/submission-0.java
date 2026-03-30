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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        else if(root.right == null && root.left == null){
            return root;
        }else{
            if(root.right == null){
                root.right = invertTree(root.left);
                root.left = null;
            }
            else if(root.left == null){
                root.left = invertTree(root.right);
                root.right = null;
            }
            else{
                TreeNode tmp = new TreeNode(root.left.val, root.left.left, root.left.right);
                root.left = invertTree(root.right);
                root.right = invertTree(tmp);
            }
            return root;
        }
    }
}
