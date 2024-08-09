/*
    title : 2 x n 타일링
 */

package juwoncode.devcourse.level2;

public class PGS_2xN_타일링 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        int[] array = new int[60001];
        array[0] = 1; array[1] = 2;

        for (int i = 2; i < n; i++) {
            int sum = array[i - 1] + array[i - 2];
            array[i] = sum > 1000000007 ? sum % 1000000007 : sum;
        }

        return array[n - 1];
    }
}

/*
    n = 1 -> 1, {세}
    n = 2 -> 2, {세,세}, {가,가}
    n = 3 -> 3, {세,세,세}, {세,가,가}, {가,가,세}
    n = 4 -> 5, {세,세,세,세}, {가,가,가,가}, {세,가,가,세}, {세,세,가,가}, {가,가,세,세}
    n = 5 -> 8, {세,세,세,세,세}, {가,가,세,세,세}, {세,가,가,세,세}, {세,세,가,가,세}, {세,세,세,가,가}, {가,가,가,가,세}, {가,가,세,가,가}, {세,가,가,가,가}
*/
