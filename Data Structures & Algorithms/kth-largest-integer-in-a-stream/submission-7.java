class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int n : nums) {
            add(n);   // reuse logic
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        if (pq.size() > k) {
            pq.poll();   // remove smallest
        }

        return pq.peek();  // kth largest
    }
}