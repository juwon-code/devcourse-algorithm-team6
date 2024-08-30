import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int max_val = Integer.MAX_VALUE; 

        for (int i = 0; i < stones.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                max_val = Math.min(max_val, stones[deque.peekFirst()]);
            }
        }

        return max_val;
    }
}
