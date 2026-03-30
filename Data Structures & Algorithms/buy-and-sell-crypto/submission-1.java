class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        int prof = 0;
        for(int p: prices){
            if(minPrice > p){
                minPrice = p;
            }

           

            prof = Math.max(prof,p-minPrice);

        }

        return prof;
    }
}
