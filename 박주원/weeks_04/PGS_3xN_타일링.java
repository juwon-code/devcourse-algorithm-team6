package juwoncode.devcourse.level2;

public class PGS_3xN_타일링 {
    private static int DIVISOR = 1000000007;

    public static int solution(int n) {
        long[] array = new long[n + 1];

        array[0] = 1;
        array[2] = 3;

        // 짝수만 가능하므로 4부터 시작,
        for (int i = 4; i <= n; i += 2) {
            // 이전 짝수항에 3을 곱함.
            array[i] = array[i - 2] * 3;
            // 전전 짝수항부터 내려가며 모든 짝수항에 2를 곱한 값을 더함.
            for (int j = i - 4; j >= 0 ; j -= 2) {
                array[i] += (array[j] * 2);
            }
            array[i] %= DIVISOR;
        }

        return (int) array[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
