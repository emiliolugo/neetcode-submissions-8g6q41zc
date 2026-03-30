class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a,b) -> b-a);
        for(int n: stones){
            PQ.add(n);
        }
        while(PQ.size()>1){
            int x = PQ.poll(); int y = PQ.poll();
            if(x==y){
                continue;
            }
            else{
                PQ.add(x-y);
            }
        }
        return PQ.size() == 0 ? 0 : PQ.poll();
    }

}
