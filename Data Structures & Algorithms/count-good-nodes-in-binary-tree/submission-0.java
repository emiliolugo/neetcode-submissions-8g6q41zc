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
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return goodNodesHelper(root,root.val);
    }

    private static int goodNodesHelper(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        if(root.val >= max){
            return 1 + goodNodesHelper(root.left, root.val) + goodNodesHelper(root.right, root.val);
        }
        else{
            return goodNodesHelper(root.left, max) + goodNodesHelper(root.right, max);
        }
            
    }
}
