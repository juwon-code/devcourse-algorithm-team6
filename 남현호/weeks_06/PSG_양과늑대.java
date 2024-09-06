class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        
        visited[0] = true;
        dfs(1, 0, info, edges);
        
        return answer;
    }
    
    static void dfs(int sheep, int wolf, int[] info, int[][] edges) {
        if (sheep > wolf) answer = Math.max(answer, sheep);
        else return;
        
        for (int[] edge : edges) {
            if (visited[edge[0]] == true && visited[edge[1]] == false) {
                visited[edge[1]] = true;
                if (info[edge[1]] == 0) dfs(sheep + 1, wolf, info, edges);
                else dfs(sheep, wolf + 1, info, edges);
                visited[edge[1]] = false;
            }
        }
    }
    
    
}
