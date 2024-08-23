/*
    title : 카운트 다운
 */

package juwoncode.devcourse.level3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PGS_카운트_다운 {
    private static final int SINGLE = 1;
    private static final int DOUBLE = 2;
    private static final int TRIPLE = 3;
    private static final int BULL = 50;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(21)));
        System.out.println(Arrays.toString(solution(58)));
    }

    public static int[] solution(int target) {
        int[][] table = new int[target + 1][2];
        int[] types = {BULL, SINGLE, DOUBLE, TRIPLE};

        // 첫째 항을 제외하고 모든 항에 최댓값을 삽입한다.
        IntStream.rangeClosed(1, target).forEach(i -> table[i][0] = Integer.MAX_VALUE);

        // 모든 타입의 다트 케이스를 시도하여 테이블을 갱신한다.
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= 20; j++) {
                for (int type : types) {
                    updateTable(table, i, j, type);
                }
            }
        }

        return new int[]{table[target][0], table[target][1]};
    }

    private static void updateTable(int[][] table, int currentIndex, int pointingIndex, int type) {
        // 이전 인덱스를 구한다.
        int previousIndex = (type == BULL) ? currentIndex - BULL : currentIndex - type * pointingIndex;

        // 이전 인덱스가 0보다 작을 경우 종료한다.
        if (previousIndex < 0) {
            return;
        }

        // 타입이 BULL, SINGLE일 경우, updateSingleOrBull()을 호출한다.
        if (type == BULL || type == SINGLE) {
            updateSingleOrBull(table, currentIndex, previousIndex);
            return;
        }

        // 타입이 DOUBLE, TRIPLE일 경우, updateDoubleOrTriple()을 호출한다.
        if (type == DOUBLE || type == TRIPLE) {
            updateDoubleOrTriple(table, currentIndex, previousIndex);
        }
    }

    private static void updateSingleOrBull(int[][] table, int currentIndex, int previousIndex) {
        if (table[currentIndex][0] > table[previousIndex][0] + 1) {
            table[currentIndex][0] = table[previousIndex][0] + 1;
            table[currentIndex][1] = table[previousIndex][1] + 1;
            return;
        }
        if (table[currentIndex][0] == table[previousIndex][0] + 1) {
            table[currentIndex][1] = Math.max(table[currentIndex][1], table[previousIndex][1] + 1);
        }
    }

    private static void updateDoubleOrTriple(int[][] table, int currentIndex, int previousIndex) {
        if (table[currentIndex][0] > table[previousIndex][0] + 1) {
            table[currentIndex][0] = table[previousIndex][0] + 1;
            table[currentIndex][1] = table[previousIndex][1];
        }
    }
}
