class Solution {
    public int[] solution(int target) {
        
        int[][] answer = new int[target+1][2];
        for (int i = 1; i <= target; i++) {
            answer[i][0] = 100000;
        }
        
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i >= 50) {
                    if (answer[i][0] > answer[i-50][0] + 1) {
                        answer[i][0] = answer[i-50][0] + 1;
                        answer[i][1] = answer[i-50][1] + 1;
                    } else if (answer[i][0] == answer[i-50][0] + 1) {
                        answer[i][1] = Math.max(answer[i][1], answer[i-50][1] + 1);
                    }
                }
                if (i >= j) {
                    if (answer[i][0] > answer[i-j][0] + 1) {
                        answer[i][0] = answer[i-j][0] + 1;
                        answer[i][1] = answer[i-j][1] + 1;
                    } else if (answer[i][0] == answer[i-j][0] + 1) {
                        answer[i][1] = Math.max(answer[i][1], answer[i-j][1] + 1);
                    }
                }
                if (i >= j*2) {
                    if (answer[i][0] > answer[i-j*2][0] + 1) {
                        answer[i][0] = answer[i-j*2][0] + 1;
                        answer[i][1] = answer[i-j*2][1];
                    }
                }
                if (i >= j*3) {
                    if (answer[i][0] > answer[i-j*3][0] + 1) {
                        answer[i][0] = answer[i-j*3][0] + 1;
                        answer[i][1] = answer[i-j*3][1];
                    }
                }
            }
        }
                
        return answer[target];
    }
}
