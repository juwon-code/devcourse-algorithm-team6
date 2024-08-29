import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        String[][] boardArray = new String[m][];
        for (int i = 0; i < m; i++) {
            boardArray[i] = board[i].split("");
        }
        
        while (true) {
            List<Object> check = findFourBlocks(boardArray, m, n);
            List<int[]> intList = (List<int[]>) check.get(0);
            answer += intList.size();
            if (intList.size() == 0) {
                break;
            }
        }
        
        return answer;
    }
    
    List<Object> findFourBlocks(String[][] boardArray, int m, int n) {
        List<int[]> checkFourBlocks = new ArrayList<>();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                String now = boardArray[i][j];
                if (!now.equals(" ") && boardArray[i][j+1].equals(now) && boardArray[i+1][j].equals(now) && boardArray[i+1][j+1].equals(now)) {
                    checkFourBlocks.add(new int[]{i,j});
                    checkFourBlocks.add(new int[]{i,j+1});
                    checkFourBlocks.add(new int[]{i+1,j});
                    checkFourBlocks.add(new int[]{i+1,j+1});
                }
            }
        }
        List<int[]> checked = new ArrayList<>();
        boolean first = true;
        for (int[] pair : checkFourBlocks) {
            if (first) {
                checked.add(pair);
                first = false;
                continue;
            }
            boolean found = false;
            for (int i = 0; i < checked.size(); i++) {
                if (checked.get(i)[0] == pair[0] && checked.get(i)[1] == pair[1]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                checked.add(pair);
            }
        }
        for (int[] pair : checked) {
            boardArray[pair[0]][pair[1]] = " ";
        }
        for (int i = m-1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < i; k++) {
                    if (boardArray[i][j].equals(" ")) {
                        for (int l = i; l > 0; l--) {
                            boardArray[l][j] = boardArray[l-1][j];
                        }
                        boardArray[0][j] = " ";
                    }
                }
            }
        }
        return List.of(checked, boardArray);
    }
    
}
