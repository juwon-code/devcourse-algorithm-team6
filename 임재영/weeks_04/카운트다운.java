class Solution {
    int[][] dp;
    int INF = 100001;
    
    public int[] solution(int target) {
        dp = new int[target + 1][2];
        for(int i=1;i<=target;i++) 
            dp[i][0] = INF;
        
        return throwDart(target);
    }
    
    int[] throwDart(int n) {
        if(dp[n][0] == INF) {
            if(n >= 50) {
                int[] temp = throwDart(n - 50);
                if((temp[0] + 1 < dp[n][0]) || (temp[0] + 1 == dp[n][0] && temp[1] + 1 > dp[n][1])) {
                    dp[n][0] = 1 + temp[0];
                    dp[n][1] = 1 + temp[1];
                }
            }
            
            int start = n >= 20 ? 20 : n;
            for(int i=start;i>=1;i--) {
                for(int j=1;j<=3;j++) {
                    if(n >= i * j) {
                        int[] temp = throwDart(n - i * j);
                        int cnt = j == 1 ? 1 : 0; 
                        if((temp[0] + 1 < dp[n][0]) || (temp[0] + 1 == dp[n][0] && temp[1] + cnt > dp[n][1])) {
                            dp[n][0] = 1 + temp[0];
                            dp[n][1] = cnt + temp[1];
                        }
                    }
                }
            }
        }
        
        return dp[n];
    }
}