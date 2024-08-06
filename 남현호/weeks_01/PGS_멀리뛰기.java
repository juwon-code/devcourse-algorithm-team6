class Solution {
    public long solution(int n) {
        long answer = 0;
        
        long num1 = 1;
        long num2 = 2;
        if (n <= 2) {
            answer = n;
        } else {
            long num3 = 0;
            for (int i = 0; i < n - 2; i++) {
                num3 = num1 + num2;
                num1 = num2 % 1234567;
                num2 = num3 % 1234567;
            }
            answer = num3 % 1234567;
        }
        
        return answer;
    }
}
