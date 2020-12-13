class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        
        if (prices.length == 0) return res;

        int current = prices[0];
        for (int i = 1;i<prices.length;i++){
            if (prices[i]<prices[i-1]){
                res += (prices[i-1] - current);
                current = prices[i];
            }
        }
        if (prices[prices.length-1]>current){
            res += (prices[prices.length-1] - current);
        }
        return res;
    }
}