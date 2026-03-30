class KthLargest {
    List<Integer> ls;
    final int K;
    public KthLargest(int k, int[] nums) {
        K = k-1;
        ls = new ArrayList<>();
        for (int num : nums) {
            ls.add(num); 
        }        
        Collections.sort(ls, (a, b) -> Integer.compare(b, a));
    }
    
    public int add(int val) {
        if(ls.size() != 0){
            int l = 0; int r = ls.size()-1;

            while(l <= r){
            int mid = l + (r-l)/2;
        if (val >= ls.get(mid) && (mid == 0 || val <= ls.get(mid - 1))) {
                ls.add(mid,val);
                break;
            }
            else if(val >= ls.get(mid)){
                r = mid -1;
            }
            else{
                l = mid +1;
            }
        }
        }
        else{
            ls.add(val);
        }

        
        
        return ls.get(K);
    }
}
