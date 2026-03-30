class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int k = 0;
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        while(k < nums.length){

            if (k > 0 && nums[k] == nums[k - 1]){
                k++;
                continue;
            } 

            int r = nums.length-1;
            int l = k+1;
            while(l < r){
                int sum = nums[r]+nums[l]+nums[k];
                if(sum==0 && r!=l && r!=k && k!=l){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[r]);
                    tmp.add(nums[l]);
                    tmp.add(nums[k]);
                    ls.add(tmp);
                     l++;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
                else if(sum > 0){
                    r--;
                }
                else{
                    l++;
                }
            }
           k++;   
        }
        return ls;
    }
}
