class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] prods = new int[nums.length];

        for(int i = 0; i < prefix.length;i++){
            if(i == 0){
                prefix[i] = 1;
            }
            else{
                prefix[i] = prefix[i-1]*nums[i-1];
            }
        }

        postfix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < prods.length;i++){
            prods[i] = prefix[i] * postfix[i];
        }
        return prods;
    }
}  
