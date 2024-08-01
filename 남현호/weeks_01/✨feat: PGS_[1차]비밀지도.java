class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String decoding = "";
            
            String decimalToBinary1 = Integer.toBinaryString(arr1[i]);
            String decimalToBinary2 = Integer.toBinaryString(arr2[i]);
            
            int plusZero1 = n - decimalToBinary1.length();
            int plusZero2 = n - decimalToBinary2.length();
            for (int j = 0; j < plusZero1; j++) decimalToBinary1 = "0" + decimalToBinary1;
            for (int j = 0; j < plusZero2; j++) decimalToBinary2 = "0" + decimalToBinary2;
            char[] charArr1 = decimalToBinary1.toCharArray();
            char[] charArr2 = decimalToBinary2.toCharArray();
            
            for (int j = 0; j < n; j++) {
                if (charArr1[j] == '1' || charArr2[j] == '1') {
                    decoding += "#";
                } else {
                    decoding += " ";
                }
            }
            
            answer[i] = decoding;
        }
        
        return answer;
    }
}
