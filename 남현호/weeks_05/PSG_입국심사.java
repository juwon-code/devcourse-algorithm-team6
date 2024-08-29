class Solution {
    public long solution(int n, int[] times) {        
        long min = 0l;
        long max = 100000000000000l;
        long person = 0l;
        while (min != max) {
            long mid = (min + max) / 2;
            person = minute(mid, n, times);
            if (person < n) {
                min = (min + max) / 2 + 1;
            } else {
                max = (min + max) / 2;
            }
        }
        
        return min;
    }
    
    static long minute(Long mid, int n, int[] times) {
        long person = 0l;
        for (int time : times) {
            person += mid / time;
        }
        return person;
    }
}
