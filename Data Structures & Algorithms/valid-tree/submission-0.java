class Solution {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!= n-1) return false;

        parent = new int[n];
        for(int i =0; i<n;i++) parent[i] = i;

        for(int[] edge: edges){
            if (find(edge[0]) == find(edge[1])) return false;
            union(edge[0],edge[1]);
        }

        int root = find(0);

        for(int i = 1; i < n; i++){
            if(find(i)!= root) return false;
        }
        return true;
    }
    int find(int i){
            if(parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
    }

    void union(int i, int j){
            parent[find(i)] = find(j);
    }
}
