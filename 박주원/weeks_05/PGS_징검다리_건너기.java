package juwoncode.devcourse.level3;

import java.util.*;

public class PGS_징검다리_건너기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    private static class Stone {
        int index;
        int value;

        private Stone (int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Stone> deque = new ArrayDeque<>();

        for (int i = 0; i < stones.length; i++) {
            Stone stone = new Stone(i, stones[i]);

            // 첫 돌의 인덱스가 범위를 벗어날 경우 제거한다.
            if (!deque.isEmpty() && k <= i - deque.peekFirst().index) {
                deque.pollFirst();
            }

            // 마지막 돌이 새로운 돌보다 작을 경우 제거한다.
            while (!deque.isEmpty() && stone.value > deque.peekLast().value) {
                deque.pollLast();
            }

            deque.addLast(stone);

            // 첫 돌의 값과 비교하여 답을 최솟값으로 갱신한다.
            if (i >= k - 1) {
                answer = Math.min(answer, deque.peekFirst().value);
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
