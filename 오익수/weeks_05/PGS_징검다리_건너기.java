class Solution {
    public boolean cross(int[] stones, int l, int friends) {
        int zeroCount = 0;
        for (int stone : stones) {
            if (stone - friends < 0) {
                zeroCount++;
            } else { 
                zeroCount = 0;
            }
            if (zeroCount >= l) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int[] stones, int k) {
        int min = 1;
        int max = 200000000;
        
        while (min <= max) {
            int mid = (min + max) / 2; // 기준을 세우고,
            if (cross(stones, k, mid)) { 
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }
}
