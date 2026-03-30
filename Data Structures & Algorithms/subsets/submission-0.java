class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        subsetsHelper(nums, 0, new ArrayList<Integer>(), ls);
        return ls;
    }

    private void subsetsHelper(int[] nums, int index, List<Integer> curr, List<List<Integer>> ls){
        if(index == nums.length){
            ls.add(new ArrayList<>(curr));
        }
        else{
            
            curr.add(nums[index]);
            subsetsHelper(nums, index + 1, curr, ls);
            curr.remove(curr.size() - 1);

            subsetsHelper(nums, index + 1, curr, ls);
        }
    }

}
