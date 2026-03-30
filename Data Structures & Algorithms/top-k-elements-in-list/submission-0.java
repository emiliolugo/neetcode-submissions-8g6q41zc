class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> M = new HashMap<>();

        List<Integer>[] freq = new List[nums.length+1];

        for(int i  = 0; i < freq.length;i++){
            freq[i] = new ArrayList<>();
        }
        for(int n: nums){
            M.put(n,M.getOrDefault(n,0)+1);
        }

        for(int i: M.keySet()){
            freq[M.get(i)].add(i);
        }


        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
