class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];

        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            if(find(edge[0]) == find(edge[1])) return new int[]{edge[0],edge[1]};
            join(edge[0],edge[1]);
        }

        //will never be reached
        return new int[]{-1,-1};
    }

    int find(int i){
        if(parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    void join(int i, int j){
        parent[find(i)] = find(j);
    } 
}
