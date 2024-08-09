class Solution {
    public int solution(String[][] board, int h, int w) {
        // 인접 셀과 같은 값인 셀의 개수를 셀 변수
        int cnt = 0;
        // board의 크기 (정사각형 배열 가정)
        int n = board.length;
        
        // 네 가지 이동 방향 (오른쪽, 아래쪽, 위쪽, 왼쪽)
        //가독성 고려해서 이차원 배열로 작성
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        
        // 각 방향으로 탐색
        for (int[] dir : directions) {
            // 현재 셀에서 이동한 후의 위치 계산
            int h_check = h + dir[0];
            int w_check = w + dir[1];
             
            // 새로운 위치가 board의 범위 내에 있는지 확인
            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                // 새로운 위치의 셀 값이 현재 셀 값과 같은지 확인
                if (board[h][w].equals(board[h_check][w_check])) {
                    // 같은 값인 경우 카운트 증가
                    cnt++;
                }
            }
        }
        // 결과 반환 (같은 값인 인접 셀의 개수)
        return cnt;
    }
}
