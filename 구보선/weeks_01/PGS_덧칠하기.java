class Solution {
    public int solution(int n, int m, int[] section) {
        int max = 0;
        int cnt = 0;
        for (int point : section){
            if(max <= point){
                max = point + m;
                cnt++;
            }
        }
        return cnt;
    }
}
