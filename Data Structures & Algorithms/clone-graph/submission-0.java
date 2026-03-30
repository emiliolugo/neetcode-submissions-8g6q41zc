/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> oTn = new HashMap<>();
        return dfs(node, oTn);
        

    }

    private Node dfs(Node node, Map<Node,Node> oTn){
            if(node == null){
                return null;
            }
            if(oTn.containsKey(node)){
                return oTn.get(node);
            }

            Node tmp = new Node(node.val);

            oTn.put(node, tmp);
            for(Node neighbor: node.neighbors){
                tmp.neighbors.add(dfs(neighbor,oTn));
            }
            return tmp;
        }
}