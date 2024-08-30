package juwoncode.devcourse.level3;

import java.util.Arrays;

public class PGS_네트워크 {
    private static boolean[] isVisited;
    private static int answer = 0;

    public static int solution(int n, int[][] computers) {
        // 그룹 배열, 방문 배열을 false로 초기화.
        isVisited = new boolean[n];
        Arrays.fill(isVisited, false);

        for (int i = 0; i < n; i++) {
            // 방문하지 않은 경우 그룹개수 1 증가 및 dfs 호출.
            if (!isVisited[i]) {
                answer++;
                dfs(i, computers, n);
            }
        }

        return answer;
    }

    public static void dfs(int index, int[][] computers, int n) {
        // 현재 인덱스를 방문 처리.
        isVisited[index] = true;

        for (int i = 0; i < n; i++) {
            // 방문하지 않았고, 다음 인덱스와 연결되었을 경우 재귀 호출.
            if (!isVisited[i] && computers[index][i] == 1) {
                dfs(i, computers, n);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
