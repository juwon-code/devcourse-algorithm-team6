class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = Long.MAX_VALUE;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canProcessAll(n, times, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canProcessAll(int n, int[] times, long time) {
        long count = 0;
        for (int t : times) {
            count += time / t;
            if (count >= n) {
                return true;
            }
        }
        return false;
    }
}