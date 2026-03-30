class KthLargest {
    private PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n: nums){
            PQ.add(n);
        }
    }
    
    public int add(int val) {
        PQ.add(val);
        PriorityQueue<Integer> PQ1 = new PriorityQueue<>(PQ);
        for(int i = 1; i < k; i++){
            PQ1.poll();
        }
        return PQ1.poll();
    }
}
