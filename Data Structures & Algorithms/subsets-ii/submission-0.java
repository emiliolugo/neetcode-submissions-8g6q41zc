class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ls,0,nums, new ArrayList<>());
        return ls;
    }

    private void backtrack(List<List<Integer>> ls, int index, int[] nums, List<Integer> curr){
        if(index == nums.length){
            if(!ls.contains(curr)){
            ls.add(new ArrayList<>(curr));}
        }
        else{
            for(int i = index; i < nums.length; i++){
                curr.add(nums[i]);
                backtrack(ls,i+1,nums,curr);

                curr.remove(curr.size()-1);
                backtrack(ls,i+1,nums,curr);
            }
        }
    }
}
