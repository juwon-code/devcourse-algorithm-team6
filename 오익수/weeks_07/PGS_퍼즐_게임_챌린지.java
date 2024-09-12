class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        long minLevel = 1;
        long maxLevel = limit;
        
        while (minLevel < maxLevel) {
            long mid = minLevel + (maxLevel - minLevel) / 2;
            
            if (solvedAllPuzzles(diffs, times, mid, limit)) {
                maxLevel = mid;
            } else {
                minLevel = mid + 1;
            }
        }
        return (int) minLevel;
    }
    
    private static boolean solvedAllPuzzles(int[] diffs, int[] times, long level, long limit) {
        
        long totalTime = times[0];
        
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] > level) {
                totalTime += (diffs[i] - level) * (times[i-1] + times[i]);
            }
            totalTime += times[i];
            if (totalTime > limit) return false;
        }
        return true;
    }
}
