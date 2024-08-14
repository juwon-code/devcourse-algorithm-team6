import java.util.*;

class Solution {
    
    static List<Set<String>> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        result = new ArrayList<>();
        String[] users = new String[banned_id.length];

        ArrayList<ArrayList<String>> readyToBan = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < banned_id.length; i++) {
            String ban = banned_id[i];
            ArrayList<String> candidates = new ArrayList<String>();
            for (String user : user_id) {
                if (ban.length() != user.length()) continue;
                boolean result = true;
                for (int j = 0; j < ban.length(); j++) {
                    if (ban.charAt(j) == '*') continue;
                    if (ban.charAt(j) == user.charAt(j)) continue;
                    result = false;
                }
                if (result) {
                    candidates.add(user);
                }
                result = true;
            }
            readyToBan.add(candidates);
        }
        
        fors(0, readyToBan, users);
        
        return result.size();
    }
    
    static void fors(int index, ArrayList<ArrayList<String>> readyToBan, String[] users) {
        if (index == users.length) {
            Set<String> set = new TreeSet<>();
            for (String user : users) {
                set.add(user);
            }
            if (set.size() == users.length && !result.contains(set)) {
                result.add(set);
            }
            return;
        }

        for (String user : readyToBan.get(index)) {
            users[index] = user;
            fors(index + 1, readyToBan, users);
        }
    }
    
}
