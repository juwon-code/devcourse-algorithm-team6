class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        for (int i = 0; i < length; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }
        
        int leftRight = length - 1;
        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            leftRight = Math.min(leftRight, i + length - next + Math.min(i, length - next));
        }
        return answer + leftRight;
    }
}
