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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(root,0, ls);
        return ls;
    }

    private void dfs(TreeNode root, int depth, ArrayList<Integer> ls){
        if(root == null){
            return;
        }

        if(depth == ls.size()){
            ls.add(root.val);
        }

        dfs(root.right, depth+1, ls);
        dfs(root.left, depth+1, ls);

    }
}
