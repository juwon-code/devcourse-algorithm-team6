class Solution {
    int[] diffs;
    int[] times;
    long limit;

    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;

        int left = 0;
        int right = Integer.MAX_VALUE-1;
        int mid;

        while (left < right) {
            mid = left + (right - left + 1) / 2;

            if (level(mid)) {
                right = mid-1;
            } else {
                left = mid;
            }
        }

        return left+1;
    }

    public boolean level(int i) {
        long lim = limit;
        lim -= times[0];

        for (int j = 1; j < diffs.length; j++) {
            if (i >= diffs[j]) {
                lim -= times[j];
            } else {
                lim -= (diffs[j] - i) * (times[j] + times[j - 1]) + times[j];
            }
        }

        return lim >= 0;
    }
}
