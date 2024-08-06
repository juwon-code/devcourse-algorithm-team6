class Solution {
    long[] dp = new long[2001];
    public long solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2; // 1+1, 2
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}