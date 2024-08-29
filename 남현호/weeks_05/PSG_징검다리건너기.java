import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int max = 200000000;
        int len = stones.length;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && k <= i - deque.peekFirst()) {
                deque.pollFirst();
            }
            
            while (!deque.isEmpty() && stones[deque.peekLast()] < stones[i]) {
                deque.pollLast();
            }
            
            deque.addLast(i);
            
            if (i >= k - 1) {
                max = Math.min(max, stones[deque.peekFirst()]);
            }
        }
        
        return max;
    }
}
