package juwoncode.devcourse.level2;

import java.util.Arrays;

public class PGS_퍼즐_게임_챌린지 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30));
        System.out.println(solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59));
        System.out.println(solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723));
        System.out.println(solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L));
    }

    public static int solution(int[] difficults, int[] times, long limit) {
        // 최소값은 1로 고정, 최대값은 탐색하여 설정한다.
        long lowLevel = 1;
        long topLevel = Arrays.stream(difficults).max().getAsInt();

        while (lowLevel < topLevel) {
            long midLevel = (lowLevel + topLevel) / 2;
            long totalTime = times[0];

            // 소요시간을 계산한다.
            for (int i = 1; i < difficults.length; i++) {
                if (midLevel < difficults[i]) {
                    // (문제레벨 - 현재레벨) * (문제시간 + 이전시간);
                    totalTime += (difficults[i] - midLevel) * (times[i] + times[i - 1]);
                }
                // 조건과 관계없이 문제시간을 더한다.
                totalTime += times[i];
            }

            if (totalTime > limit) {
                lowLevel = midLevel + 1;
            } else {
                topLevel = midLevel;
            }
        }

        return (int) lowLevel;
    }
}
