package pgs.java.study;
import java.util.Objects;
public class week2_1 {
    public static void main(String[] args) {
        String[][] board;
        int h;
        int w;
        board = new String[][]{{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        h = 1;
        w = 1;
        System.out.println(Solution1.solution(board,h,w));
    }
}

class Solution1 {
    public static int solution(String[][] board, int h, int w) {
        int answer = 0;
        String target = board[h][w];
        int rows = board.length;
        int cols = board[0].length;

        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newH = h + dh[i];
            int newW = w + dw[i];

            if (newH >= 0 && newH < rows && newW >= 0 && newW < cols) {
                if (Objects.equals(board[newH][newW], target)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
