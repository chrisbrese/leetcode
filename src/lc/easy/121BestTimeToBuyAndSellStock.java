class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int lastVal = 100000;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lastVal){
                for(int j = i+1; j < prices.length; j++){
                    if(prices[j] > prices[i] && prices[j]-prices[i] > profit){
                        profit = prices[j] - prices[i];
                    }
                }
                lastVal = prices[i];
            }
        }
        
        return profit;
    }
}
