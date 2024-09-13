import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int maxSheep = 0; 

    public int solution(int[] info, int[][] edges) {

        List<Integer>[] tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        List<Integer> possibleNodes = new ArrayList<>();
        possibleNodes.add(0); 

        dfs(0, 0, 0, info, tree, possibleNodes);

        return maxSheep; 
    }

    private void dfs(int node, int sheep, int wolves, int[] info, List<Integer>[] tree, List<Integer> possibleNodes) {

        if (info[node] == 0) {
            sheep++;
        } else {
            wolves++;
        }

        if (wolves >= sheep) {
            return;
        }

        maxSheep = Math.max(maxSheep, sheep);

        List<Integer> nextPossibleNodes = new ArrayList<>(possibleNodes);
        
        nextPossibleNodes.remove(Integer.valueOf(node)); 

        nextPossibleNodes.addAll(tree[node]);

        for (int nextNode : nextPossibleNodes) {
            dfs(nextNode, sheep, wolves, info, tree, nextPossibleNodes);
        }
    }
}
