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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     
            if(isDescendant(root.right,q) && isDescendant(root.right,p)){
                return lowestCommonAncestor(root.right,p,q);
            }
            else if(isDescendant(root.left,q) && isDescendant(root.left,p)){
                return lowestCommonAncestor(root.left,p,q);
            }
            else{
                return root;
            }

        
    }

    private static boolean isDescendant(TreeNode root, TreeNode node){
        if (root == null) return false;
        if (root.val == node.val) return true;
        return isDescendant(root.left, node) || isDescendant(root.right, node);
    }
}
