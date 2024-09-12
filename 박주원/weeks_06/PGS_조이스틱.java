package juwoncode.devcourse.level2;

public class PGS_조이스틱 {
    private static final int[] MOVES = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
        System.out.println(solution("BBAAAAAAA"));
    }

    public static int solution(String name) {
        char[] nameChars = name.toCharArray();
        final int LENGTH = name.length();
        int upDownCount = 0;

        // 조이스틱 상하 횟수를 구한다.
        for (int i = 0; i < nameChars.length; i++) {
            upDownCount += MOVES[nameChars[i] - 'A'];
        }

        int leftRightCount = LENGTH - 1; // 꺾지 않고 쭉가는 경우로 초기화.

        // 조이스틱 좌우 횟수를 구한다.
        for(int i = 0; i < nameChars.length; i++) {
            int nextIndex = i + 1;
            while (nextIndex < LENGTH && nameChars[nextIndex] == 'A') {
                nextIndex++;
            }

            // 앞으로 진행하다가 A를 만나고 뒤로 꺾음.
            leftRightCount = Math.min(leftRightCount, i * 2 + LENGTH - nextIndex);

            // 뒤로 진행하다가 A를 만나고 앞으로 꺾음.
            leftRightCount = Math.min(leftRightCount, (LENGTH - nextIndex) * 2 + i);
        }

        return upDownCount + leftRightCount;
    }
}
