package juwoncode.devcourse.level3;

import java.util.*;
import java.util.stream.IntStream;

public class PGS_양과_늑대 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}));
    }

    private static List<List<Integer>> graphs;
    private static int[] globalInfo;
    private static int maxSheepCount;

    public static int solution(int[] info, int[][] edges) {
        final int INFO_LENGTH = info.length;
        globalInfo = info.clone();

        // 그래프 초기화.
        graphs = new ArrayList<>();
        IntStream.range(0, INFO_LENGTH).forEach(i -> graphs.add(new ArrayList<>()));
        for (int[] edge : edges) {
            graphs.get(edge[0]).add(edge[1]);
        }

        // dfs 호출.
        List<Integer> graph = new ArrayList<>();
        graph.add(0);
        dfs(0, 0, 0, graph);


        return maxSheepCount;
    }

    private static void dfs(int sheepCount, int wolfCount, int index, List<Integer> graph) {
        // 양과 늑대의 수를 증가시킨다.
        if (globalInfo[index] == 0) {
            sheepCount++;
            maxSheepCount = Math.max(maxSheepCount, sheepCount);
        } else {
            wolfCount++;
        }

        // 늑대가 양보다 많아질 경우 종료한다.
        if (wolfCount >= sheepCount) {
            return;
        }

        // 다음 그래프를 만드는데, 현재 그래프에서 하나씩 제거한다.
        List<Integer> nextGraph = new ArrayList<>(graph);
        if (!graphs.get(index).isEmpty()) {
            nextGraph.addAll(graphs.get(index));
        }
        nextGraph.remove(Integer.valueOf(index)); // 인덱스에 해당되는 값을 제거한다.

        for (int nextIndex : nextGraph) {
            dfs(sheepCount, wolfCount, nextIndex, nextGraph);
        }
    }
}
