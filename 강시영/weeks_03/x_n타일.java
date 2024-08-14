package AlgorithmStudy;

public class x_n타일 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int num1 = 1;
            int num2 = 2;
            int num = 0;

            if(n > 2){
                for(int i = 0; i < n - 2; i++){
                    num = (num1 + num2) % 1000000007;
                    num1 = num2 % 1000000007;
                    num2 = num % 1000000007;
                }
                answer = num;
            }

            else if(n == 1){
                answer = 1 % 1000000007;
            } else {
                answer = 2 % 1000000007;
            }
            return answer;
        }
    }
}
