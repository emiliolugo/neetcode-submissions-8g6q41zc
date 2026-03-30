class Solution {
    Map<Integer,List<Integer>> edgeMap = new HashMap<>();
    int[] seen;
    public int countComponents(int n, int[][] edges) {
        seen = new int[n];
        int components = 0;
        for(int[] edge: edges){
            if(!edgeMap.containsKey(edge[0])) edgeMap.put(edge[0],new ArrayList<>());
            if(!edgeMap.containsKey(edge[1])) edgeMap.put(edge[1],new ArrayList<>());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < n; i++){
            if(seen[i] == 0){
                dfs(i);
                components++;
            }
        }

        return components;
    }

    private void dfs(int v){
        if(seen[v] == 1) return;
        seen[v] = 1;

        for(int neighbor: edgeMap.getOrDefault(v, List.of())){
            if(seen[neighbor] == 0) dfs(neighbor);
        }
    }
}
