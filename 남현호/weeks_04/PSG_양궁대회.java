import java.util.*;

class Solution {
    
    static List<Integer> queue = new ArrayList<>();
    static Integer[] maxArray = {};
    static int[] plan = new int[11];
    static int score = 0;
    static int enemy;
    static int max = 0;
    static int left;
    
    public int[] solution(int n, int[] info) {
        
        int[] answer = new int[11];
        left = n;
        
        for (int i = 0; i <= 10; i++) {
            if (info[i] != 0) {
                enemy += 10 - i;
            }
        }

        for (int i = 1; i <= 10; i++) {
            plan[i] = info[10 - i] + 1;
        }

        for (int j = left; j >= 0; j--) {
            left -= j;
            if (j != 0) {
                queue.add(0);
            }
            dfs(1, info);
            left = n;
        }

        if (maxArray.length == 0) {
            answer = new int[]{-1};
        } else {
            int count = 0;
            for (Integer i : maxArray) {
                answer[10 - i] = plan[i];
                count += plan[i];
            }
            answer[10] = n - count;
        }
        
        return answer;
    }
    
    static void dfs(int startIndex, int[] info) {
        if (left == 0) {
            if (score > enemy && score - enemy > max) {
                max = score - enemy;
                maxArray = queue.toArray(new Integer[queue.size()]);
            }
            Integer remove = queue.remove(queue.size() - 1);
            score -= remove;
            if (info[10 - remove] != 0) {
                enemy += remove;
            }
            left += plan[remove];
            return;
        }

        for (int i = startIndex; i <= 10; i++) {
            if (left >= plan[i]) {
                queue.add(i);
                left -= plan[i];
                score += i;
                if (info[10 - i] != 0) {
                    enemy -= i;
                }
                dfs(i + 1, info);
            }
        }

        if (left > 0) {
            if (!queue.isEmpty()) {
                Integer remove = queue.remove(queue.size() - 1);
                score -= remove;
                if (info[10 - remove] != 0) {
                    enemy += remove;
                }
                left += plan[remove];
            }
        }
    }
}
