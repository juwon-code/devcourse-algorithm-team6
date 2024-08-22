class Solution {
    public int[] solution(int target) {
        int[] dp = new int[target + 1];
        int[] singleCount = new int[target + 1];
        
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            singleCount[i] = 0;
        }
        
        for (int i = 1; i <= target; i++) {
            // Single
            for (int j = 1; j <= 20; j++) {
                if (i >= j && dp[i - j] + 1 <= dp[i]) {
                    if (dp[i - j] + 1 < dp[i] || singleCount[i - j] + 1 > singleCount[i]) {
                        dp[i] = dp[i - j] + 1;
                        singleCount[i] = singleCount[i - j] + 1;
                    }
                }
            }
            
            // Double
            for (int j = 1; j <= 20; j++) {
                if (i >= 2*j && dp[i - 2*j] + 1 < dp[i]) {
                    dp[i] = dp[i - 2*j] + 1;
                    singleCount[i] = singleCount[i - 2*j];
                }
            }
            
            // Triple
            for (int j = 1; j <= 20; j++) {
                if (i >= 3*j && dp[i - 3*j] + 1 < dp[i]) {
                    dp[i] = dp[i - 3*j] + 1;
                    singleCount[i] = singleCount[i - 3*j];
                }
            }
            
            // Bull's eye
            if (i >= 50 && dp[i - 50] + 1 <= dp[i]) {
                if (dp[i - 50] + 1 < dp[i] || singleCount[i - 50] + 1 > singleCount[i]) {
                    dp[i] = dp[i - 50] + 1;
                    singleCount[i] = singleCount[i - 50] + 1;
                }
            }
        }
        
        return new int[]{dp[target], singleCount[target]};
    }
}
