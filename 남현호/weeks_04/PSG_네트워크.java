import java.util.*;

class Solution {
    
    static List<int[]> queue = new ArrayList<>();
    static int network = 0;
    
    public int solution(int n, int[][] computers) {
        
        boolean[] check = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 0) continue;
                queue.add(new int[]{i,j});
                dfs(n, computers, check, i, j);
            }
        }
        
        return network;
    }
    
    void dfs(int n, int[][] computers, boolean[] check, int i, int j) {
        
        if(!check[i]){
            network++;
            check[i] = true;
        }
        if (i == j) return;
        while (!queue.isEmpty()) {
            int[] now = queue.remove(0);
            check[now[1]] = true;
            for (int k = 0; k < n; k++) {
                if (check[k]) continue;
                if (k == now[1]) continue;
                if (computers[now[1]][k] == 1) {
                    queue.add(new int[]{now[1], k});
                }
            }
        }
    }
}
