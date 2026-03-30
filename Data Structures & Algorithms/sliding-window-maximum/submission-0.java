class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int[] maxVals = new int[nums.length+1-k];
    int start = 0;
    int end = 0;
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); 
    for(int i = 0; i < nums.length; i++){
        maxHeap.offer(new int[]{nums[i],i});
        if(maxHeap.size() < k){
            end++;
            continue;
        }
        else{
            while(maxHeap.peek()[1] < start || maxHeap.peek()[1] > end){
                maxHeap.poll();
            }
            maxVals[start] = maxHeap.peek()[0];
            start++;
            end++;
        }

    }   

    return maxVals;
    
    }
}
