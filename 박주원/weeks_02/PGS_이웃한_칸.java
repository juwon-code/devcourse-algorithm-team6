/**
 * @title  : [PCCE 기출문제] 9번 / 이웃한 칸
 * @author : juwoncode
 */

package juwoncode.devcourse.level1;

public class NeighborSpace {
    public int solution(String[][] board, int height, int weight) {
        final int[][] DIRECTIONS = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        final int DIRECTION_COUNT = 4;
        int answer = 0;

        for (int i = 0; i < DIRECTION_COUNT; i++) {
            try {
                if (board[height + DIRECTIONS[i][0]][weight + DIRECTIONS[i][1]]
                        .equals(board[height][weight])) {
                    answer++;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        return answer;
    }
}
