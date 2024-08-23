class Solution {
    private boolean[] v;
    private int[][] computers;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.v = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    private void dfs(int node) {
        v[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!v[i] && computers[node][i] == 1) {
                dfs(i);
            }
        }
    }
}