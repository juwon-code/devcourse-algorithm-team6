import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int idx;
        int len = name.length();
        int move = len - 1;
        
        char[] chs = name.toCharArray();
        for (char ch : chs) {
            if (ch == 'A') {
                continue;
            }
            if (ch <= 'N') {
                answer += ch - 'A';
            } else {
                answer += 26 - (ch - 'A');
            }
        }
        
        for (int i = 0; i < len; i++) {
            idx = i + 1;
            while (idx < len && chs[idx] == 'A') idx++;
            int min = Math.min(i * 2 + len - idx, (len - idx) * 2  + i);
            move = Math.min(move, min);
        }
        
        return answer + move;
    }
}
