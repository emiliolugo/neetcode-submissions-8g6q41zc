class Solution {
    int[] seen;
    Map<Integer,List<Integer>> edges;
    List<Integer> list;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        seen = new int[numCourses];
        edges = new HashMap<>();

        for(int[] arr: prerequisites){
            if(!edges.containsKey(arr[1])) edges.put(arr[1],new ArrayList<>());
            edges.get(arr[1]).add(arr[0]);
        }

        list = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(seen[i] == 0){
                if(dfs(i)) return new int[0];
            }
        }
        if(list.size() != numCourses) return new int[0];
        int[] ret = new int[numCourses];

        for(int i = 0; i < numCourses;i++){
            ret[i] = list.removeLast();
        }
        return ret;
        
    }

    private boolean dfs(int index){
        seen[index] = 1;

        for(int i: edges.getOrDefault(index,List.of())){
            if(seen[i] == 1) return true;

            if(seen[i] == 0 && dfs(i)) return true;;
        }

        seen[index] = 2;
        list.add(index);
        return false;
    }
}
