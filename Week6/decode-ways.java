class Solution {
    public int numDecodings(String s) {
        char[] s1 = s.toCharArray();
        int[] dp = new int[s1.length+1];
        dp[0] = 1;

        //先导0，无法解码
        if (s1[0] == '0') return 0;
        dp[1] = 1;//此处s1[0]一定不为0

        int num = 0;
        int pre = 0;
        for (int i = 1;i<s1.length;i++){
            if (i>1) pre = num;
            num = (s1[i-1]-'0')*10+(s1[i]-'0');
            
            if (num == 0){
                return 0;
            }
            //只能作为单独数字解码
            else if (num>26||num<10){
                //作为单独数字解码时出现了0，无法解码
                if (s1[i]-'0' == 0) 
                    return 0;
                else
                    dp[i+1] = dp[i];
            }
            //只能作为整体解码，前一个数字无法作为单独数字解码
            else if(num == 10 || num == 20){
                dp[i+1] = dp[i-1];
            }
            else{
                dp[i+1] = dp[i]+dp[i-1];
            }
            
        }
        return dp[s1.length];
    }
}