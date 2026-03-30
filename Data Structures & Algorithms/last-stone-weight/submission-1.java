class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int s: stones) pq.offer(s);

        while(pq.size() > 1){
            int s1 = pq.poll();
            int s2 = pq.poll();

            if(s1 == s2) continue;

            pq.offer(Math.abs(s1-s2));
        }

        return pq.size() == 1 ? pq.poll(): 0;
    }
}
