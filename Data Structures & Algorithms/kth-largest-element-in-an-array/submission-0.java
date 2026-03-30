class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int n: nums){
            PQ.add(n);
            if(PQ.size()>k){
                PQ.poll();
            }
        }
        return PQ.poll();
    }
}
