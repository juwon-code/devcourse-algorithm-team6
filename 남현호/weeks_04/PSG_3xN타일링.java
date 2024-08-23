class Solution {
    public int solution(int n) {
        
        if (n % 2 == 1) return 0;
        if (n/2 == 1) return 3;
        if (n/2 == 2) return 11;
        
        long[] answer = new long[n/2];
        answer[0] = 3;
        answer[1] = 11;
        if (n/2 >= 3) {
            for (int i = 2; i < n/2; i++) {
                if (4 * answer[i-1] - answer[i-2] < 0) {
                    answer[i] = 4 * answer[i-1] - answer[i-2] + 1000000007;
                } else {
                    answer[i] = (4 * answer[i-1] - answer[i-2]) % 1000000007;
                }
            }
        }
        
        return (int)answer[n/2 - 1];
    }
}
