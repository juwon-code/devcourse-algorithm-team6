class Solution {
    public static long solution(int n) {
        final long MOD = 1000000007;
        long[] answer = new long[Math.max(n / 2 + 1, 3)];
        answer[0] = 0;
        answer[1] = 3;
        answer[2] = 11;

        int index = n / 2;
        if (index < 3) return answer[index];

        for (int i = 3; i <= index; i++) {
            long sum = 0;
            for (int j = 1; j < i - 1; j++) {
                sum += answer[j];
            }
            answer[i] = ((3 * answer[i - 1]) + (2 * sum) + 2) % MOD;
        }

        return answer[index];
    }

}