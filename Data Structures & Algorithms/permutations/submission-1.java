class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ls = new ArrayList<>();
       permuteHelp(ls,nums,new ArrayList<>());
       return ls;
    }

    private void permuteHelp(List<List<Integer>> ls, int[] nums, List<Integer> curr){
        if(nums.length==curr.size()){
            ls.add(new ArrayList<>(curr));
        }
        else{
            for(int i = 0; i < nums.length; i++){
                if(curr.contains(nums[i])){
                    continue;
                }
                curr.add(nums[i]);
                permuteHelp(ls,nums,curr);

                curr.remove(curr.size() - 1);
            }
        }
    }
}
