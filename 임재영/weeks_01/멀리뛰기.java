class Solution {
    public long solution(int n) {
        long[] pb = new long[n+2];
        for (int i = 0;i<3;i++)
            pb[i] = i;
        for (int j = 3;j<=n;j++)
            pb[j] = (pb[j-1] + pb[j-2])%1234567;
        return pb[n];
    }
}