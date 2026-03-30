class Solution {
    public int countComponents(int n, int[][] edges) {
        
        class UnionFind{
            int[] parent;
            UnionFind(int n){
                parent = new int[n];
                for (int i = 0; i < n; i++) parent[i] = i;
            }
                

            int find(int i){
                if(parent[i] != i) parent[i] = find(parent[i]);
                return parent[i];
            }

            void union(int i, int j){
                parent[find(i)] = find(j);
            }
        }

        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0],edge[1]);
        }

        Set<Integer> parents = new HashSet<>();
        for(int i = 0; i < n; i++){
            parents.add(uf.find(i));
        }
        return parents.size();
         
    }
}
