class Solution {
    public static long solution(int n, int[] times) {

        long maxTime = times[0];
        for (int time : times) {
            if (time > maxTime) {
                maxTime = time;
            }
        }
        long fast = 0;
        long slow = maxTime * n;
        long answer = slow;

    
        while (fast <= slow) {
            long mid = (fast + slow) / 2; 
            long people = 0;

            for (int time : times) {
                people += mid / time;
            }

            if (people >= n) { 
                answer = Math.min(answer, mid);  
                slow = mid - 1;
            } else {
                fast = mid + 1;
            }
        }
        return answer;
    }
