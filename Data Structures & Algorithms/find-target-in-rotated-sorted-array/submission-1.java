class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int min = l; 
        
        if(target >= nums[min] && target <= nums[nums.length-1] ){
            l = min;
            r = nums.length-1;
            
        }
        else{
            l = 0;
            r = min;
        }
        while( l <= r){
                int mid = l + (r-l)/2;
                if(nums[mid]==target){
                    return mid;
                }
                else if(nums[mid] > target){
                    r = mid-1;
                }
                else{
                    l = mid + 1;
                }
            }
        return -1;
    }
}
