package juwoncode.devcourse.level2;

import java.util.Arrays;

public class PGS_양궁대회 {
    private static final int POINT_COUNT = 11;
    private static final int MAX_POINTS = 10;
    private static int[] lionInfo = new int[POINT_COUNT];
    private static int[] answer = new int[POINT_COUNT];
    private static int maxScore = 0;

    public static int[] solution(int totalCount, int[] apeachInfo) {
        calculate(0, totalCount, apeachInfo);

        // 최고 점수가 -1일 경우, 아니면 정답 배열 반환.
        return maxScore == 0 ? new int[]{-1} : answer;
    }

    private static void calculate(int index, int remaining, int[] apeachInfo) {
        // 인덱스가 과녁 개수와 같거나, 남은 화살이 0일 경우 점수 계산.
        if (index == POINT_COUNT || remaining == 0) {
            lionInfo[MAX_POINTS] += remaining;
            evalScore(apeachInfo);
            lionInfo[MAX_POINTS] -= remaining;
            return;
        }

        // 남은 화살이 어피치 과녁값보다 클 경우 재귀 수행.
        if (remaining > apeachInfo[index]) {
            lionInfo[index] = apeachInfo[index] + 1;
            calculate(index + 1, remaining - lionInfo[index], apeachInfo);
            lionInfo[index] = 0;
        }

        calculate(index + 1, remaining, apeachInfo);
    }

    private static void evalScore(int[] apeachInfo) {
        int lionScore = 0, apeachScore = 0;

        // 라이언과 어피치의 점수 계산.
        for (int i = 0; i < MAX_POINTS; i++) {
            if (apeachInfo[i] == 0 && lionInfo[i] == 0) {
                continue;
            }
            if (apeachInfo[i] < lionInfo[i]) {
                lionScore += MAX_POINTS - i;
            } else {
                apeachScore += MAX_POINTS - i;
            }
        }
        int resultScore = lionScore - apeachScore;

        // 현재 점수가 최고 점수보다 클 경우 최고 점수 갱신.
        if (resultScore > maxScore) {
            maxScore = resultScore;
            answer = lionInfo.clone();
            return;
        }

        // 현재 점수가 최고 점수와 같을 경우, 낮은 점수에 많이 맞추면 갱신.
        if (resultScore == maxScore) {
            for (int i = MAX_POINTS; i > 0; i--) {
                if (lionInfo[i] > answer[i]) {
                    answer = lionInfo.clone();
                    break;
                }
                if (lionInfo[i] < answer[i]) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3})));
    }
}
