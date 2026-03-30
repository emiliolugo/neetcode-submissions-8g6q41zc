class Solution {
    List<List<Integer>> ls;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ls = new ArrayList<>();
        helper(nums, new ArrayList<>(), target,0,0);
        return ls;
    }

    private void helper(int[] nums, List<Integer> curr, int target, int sum, int index){
        if(sum > target){
            return;
        }
        if(sum==target){
            ls.add(new ArrayList<>(curr));
            return;
        }
        if(index == nums.length){
            return;
        }
        
        //repeat index
        curr.add(nums[index]);
        helper(nums,curr,target,sum+nums[index],index);
        curr.remove(curr.size() - 1); 

        // skip the number
        helper(nums, curr, target, sum, index + 1);
    }
}
