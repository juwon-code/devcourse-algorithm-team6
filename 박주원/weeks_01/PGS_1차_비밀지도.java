/**
 * @title  : [1차] 비밀지도
 * @author : juwoncode
 */

import java.util.Arrays;

public class PGS_1차_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] binaryStrings = new String[]{getBinaryString(arr1[i], n), getBinaryString(arr2[i], n)};

            for (int j = 0; j < n; j++) {
                if (binaryStrings[0].charAt(j) == '1' || binaryStrings[1].charAt(j) == '1') {
                    stringBuilder.append("#");
                    continue;
                }
                stringBuilder.append(" ");
            }

            stringBuilder.append(",");
        }

        return stringBuilder.toString().split(",");
    }

    private String getBinaryString(int integer, int digit) {
        return String.format("%" + digit + "s", Integer.toBinaryString(integer)).replace(" ", "0");
    }
}
