class Solution {
    public int solution(int n) {
        
        int mod = 1000000007;
        
        int[] rt = new int[n+1];
        rt[1] = 1;
        rt[2] = 2;
        
        for (int i = 3; i <= n; i++) {
	        rt[i] = (rt[i-1] + rt[i-2]) % mod;
        }
        return rt[n];
    }
}
