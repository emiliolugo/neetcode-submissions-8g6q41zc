class Solution {
    Map<Integer, List<Integer>> edges;
    int[] seen;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new HashMap<>();
        seen = new int[numCourses];

        for(int[] pre: prerequisites){
            if(!edges.containsKey(pre[1])){
                edges.put(pre[1], new ArrayList<>());
            }
            edges.get(pre[1]).add(pre[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(seen[i] == 0){
                if(dfs(i)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int i){
        seen[i] = 1;

        for(int n: edges.getOrDefault(i,List.of())){
            if(seen[n] == 1) return true;
            if(seen[n] == 0 && dfs(n)) return true;
        }
        seen[i] = 2;
        return false;
    }
}
