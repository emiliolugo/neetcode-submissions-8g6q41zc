class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0 ) return new int[0];
        int[] res = new int[temperatures.length];
        Stack<Integer> S = new Stack<>();
        for(int i = 0; i < temperatures.length;i++){
            while (!S.isEmpty() && temperatures[i] > temperatures[S.peek()]){
                int prev = S.pop();
                res[prev] = i-prev;
            }
            S.push(i);
        }
        return res;
        
    }
}
