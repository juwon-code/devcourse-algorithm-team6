class Solution {

    public static int solution(int n, int m, int[] section) {
        int count = 0;
        int pr_idx = -1;

        for (int i : section) {
            if (i > pr_idx) {
                count++;
                pr_idx = i + m - 1;
            }
        }

        return count;
    }
}
