class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }

        int max = 0;
        int minPrice = prices[0];
        for(int price: prices){
            if(price < minPrice){
                minPrice = price;
            }
            else{
                max = Math.max(max,price-minPrice);
            }
        }
        return max;
    }
}