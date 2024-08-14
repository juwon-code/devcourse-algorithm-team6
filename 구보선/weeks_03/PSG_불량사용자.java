import java.util.*;

class Solution {
    String[] userIds;
    String[] bannedIds;
    boolean[] visited;
    HashSet<String> uniqueSet = new HashSet<>();
    List<List<Integer>> matchList = new ArrayList<>();

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        visited = new boolean[userIds.length];

        for (String banned : bannedIds) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < userIds.length; i++) {
                if (check(userIds[i], banned)) {
                    tempList.add(i);
                }
            }
            matchList.add(tempList);
        }

        dfs(0, new boolean[userIds.length]);
        return uniqueSet.size();
    }

    void dfs(int depth, boolean[] visited) {
        if (depth == bannedIds.length) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : visited) {
                sb.append(b ? '1' : '0');
            }
            uniqueSet.add(sb.toString());
            return;
        }

        for (int i : matchList.get(depth)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, visited);
                visited[i] = false;
            }
        }
    }

    boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
