class Solution {
    Map<Integer, List<Integer>> edges;
    int[] seen;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new HashMap<>();
        seen = new int[numCourses];

        // initialize all nodes
        for (int i = 0; i < numCourses; i++) {
            edges.put(i, new ArrayList<>());
        }

        // adjacency map creation
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
        }

        // check every node
        for (int i = 0; i < numCourses; i++) {
            if (seen[i] == 0) {
                if (hasCycle(i)) return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int v) {
        seen[v] = 1;  // mark as visiting

        for (int n : edges.get(v)) {
            if (seen[n] == 1) return true;              // back edge → cycle
            if (seen[n] == 0 && hasCycle(n)) return true;
        }

        seen[v] = 2;  // mark as done
        return false;
    }
}
