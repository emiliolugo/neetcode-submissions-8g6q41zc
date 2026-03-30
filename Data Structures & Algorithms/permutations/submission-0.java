class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ls = new ArrayList<>();
       Set<Integer> unique = new HashSet<>();
       for(int n: nums){
        unique.add(n);
       }
       permuteHelp(ls,unique,new ArrayList<>());
       return ls;
    }

    private void permuteHelp(List<List<Integer>> ls, Set<Integer> nums, List<Integer> curr){
        if(nums.isEmpty()){
            ls.add(new ArrayList<>(curr));
        }
        else{
            Set<Integer> numsCopy = new HashSet<>(nums);
            for(int n: numsCopy){
                curr.add(n);
                nums.remove(n);
                permuteHelp(ls,nums,curr);

                curr.remove(curr.size() - 1);
                nums.add(n);
            }
        }
    }
}
