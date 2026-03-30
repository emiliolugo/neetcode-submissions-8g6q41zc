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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> tmp = new ArrayList<>();
        bfs(root, 0, tmp);
        return tmp;
    }

    private void bfs(TreeNode root, int level, List<List<Integer>> result){
        if(root == null){
            return;
        }
        else if(level >= result.size()){
            List<Integer> tmp = new ArrayList<>(0);
            result.add(tmp);
        }
        result.get(level).add(root.val);

        bfs(root.left, level+1, result);
        bfs(root.right, level+1, result);
    }
}
