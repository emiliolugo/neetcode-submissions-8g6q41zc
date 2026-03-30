class Solution {
    public int longestConsecutive(int[] nums) {
      PriorityQueue<Integer> TS = new PriorityQueue<Integer>();
      for(int n: nums){
        TS.add(n);
      }
      if(TS.isEmpty()){
        return 0;
      }
      int curr = TS.poll();
      int max = 1;
      int currMax = 1;
      while(!TS.isEmpty()){
        int next = TS.poll();
        while (next == curr && !TS.isEmpty()){
            next = TS.poll();
        }
      
        if(next == curr + 1){
            currMax++;
            max = Math.max(max,currMax);
        }
        else{
            currMax = 1;
        }
        curr = next;
      }

      return max;

    }
}
