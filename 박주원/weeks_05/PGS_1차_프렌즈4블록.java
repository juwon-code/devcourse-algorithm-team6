package juwoncode.devcourse.level2;

import java.util.*;
import java.util.stream.IntStream;

public class PGS_1차_프렌즈4블록 {
    private static Character[][] subBoard;
    private static Boolean[][] isChecked;

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    public static int solution(int height, int width, String[] mainBoard) {
        // 변화값이 저장될 서브 보드를 초기화 한다.
        subBoard = new Character[height][width];
        IntStream.range(0, height)
                .forEach(i -> subBoard[i] = mainBoard[i].chars().mapToObj(c -> (char) c).toArray(Character[]::new));

        int totalCount = 0;
        boolean hasBlocksToRemove = true;

        // 삭제할 블록의 개수가 존재하면 로직을 무한반복한다.
        while (hasBlocksToRemove) {
            isChecked = new Boolean[height][width];
            IntStream.range(0, height).forEach(i -> Arrays.fill(isChecked[i], false));
            hasBlocksToRemove = false;

            // 맨 아래와 우측을 제외하고, 2x2 칸을 검사한는데 checkSides()를 호출한다.
            for (int i = 0; i < height - 1; i++) {
                for (int j = 0; j < width - 1; j++) {
                    if (subBoard[i][j] != null) {
                        checkSides(subBoard[i][j], i, j);
                    }
                }
            }

            // 체크된 블록을 null 처리하고 개수를 센다.
            int removeCount = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (isChecked[i][j] != null && isChecked[i][j]) { // isChecked[][]만 단독 사용할 경우 Exception 발생!
                        subBoard[i][j] = null;
                        removeCount++;
                    }
                }
            }

            // 리스트를 사용하여 실제 블록을 삭제하고 아래로 당긴다
            for (int j = 0; j < width; j++) {
                List<Character> column = new ArrayList<>();
                // 인덱스를 내림차순으로 순회하며, null이 아닌 값을 리스트에 추가!
                for (int i = height - 1; i >= 0; i--) {
                    if (subBoard[i][j] != null) {
                        column.add(subBoard[i][j]);
                    }
                }
                // 인덱스를 내림차순으로 순회하며, 아래부터 채워넣고, 나머지는 null을 채워넣는다.
                for (int i = height - 1; i >= 0; i--) {
                    if (column.size() > height - 1 - i) {
                        subBoard[i][j] = column.get(height - 1 - i);
                    } else {
                        subBoard[i][j] = null;
                    }
                }
            }

            // 삭제된 블록이 있는 경우, 계속해서 반복한다.
            if (removeCount > 0) {
                totalCount += removeCount;
                hasBlocksToRemove = true;
            }
        }

        return totalCount;
    }

    private static void checkSides(Character character, int y, int x) {
        // x의 오른쪽과 y의 아랫쪽이 길이를 넘을 경우 반복하지 않는다.
        if (x + 1 < subBoard[0].length && y + 1 < subBoard.length) {
            if (character == subBoard[y][x + 1] && character == subBoard[y + 1][x] && character == subBoard[y + 1][x + 1]) {
                // 2x2가 일치할 경우 체크한다.
                isChecked[y][x] = true;
                isChecked[y][x + 1] = true;
                isChecked[y + 1][x] = true;
                isChecked[y + 1][x + 1] = true;
            }
        }
    }
}
