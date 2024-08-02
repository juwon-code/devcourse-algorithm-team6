class Solution {
    public int solution(int n, int m, int[] section) {
        
        int answer = 1;
        int startIndex = section[0];
        int endIndex = startIndex + m - 1;
        
        for (int i = 0; i < section.length; i++) {
            if (section[i] > endIndex) {
                answer++;
                startIndex = section[i];
                endIndex = startIndex + m - 1;
            }
        }
            
        return answer;
    }
}
