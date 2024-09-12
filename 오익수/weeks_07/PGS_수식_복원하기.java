import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        List<String> known = new ArrayList<>();
        List<String> unknown = new ArrayList<>();
        
        for (String exp : expressions) {
            if (exp.contains("X")) {
                unknown.add(exp);
            } else {
                known.add(exp);
            }
        }
        
        int maxDigit = 0;
        for (String exp : expressions) {
            for (char c : exp.toCharArray()) {
                if (Character.isDigit(c)) {
                    maxDigit = Math.max(maxDigit, c - '0');
                }
            }
        }
        
        List<Integer> bases = new ArrayList<>();
        for (int base = Math.max(2, maxDigit + 1); base <= 9; base++) {
            bases.add(base);
        }
        
        for (String exp : known) {
            bases.removeIf(base -> !isValid(exp, base));
        }
        
        String[] result = new String[unknown.size()];
        for (int i = 0; i < unknown.size(); i++) {
            result[i] = solveExpression(unknown.get(i), bases);
        }
        
        return result;
    }
    
    private boolean isValid(String exp, int base) {
        String[] parts = exp.split(" ");
        int a = Integer.parseInt(parts[0], base);
        int b = Integer.parseInt(parts[2], base);
        int c = Integer.parseInt(parts[4], base);
        return parts[1].equals("+") ? a + b == c : a - b == c;
    }
    
    private String solveExpression(String exp, List<Integer> bases) {
        String[] parts = exp.split(" ");
        Set<String> results = new HashSet<>();
        
        for (int base : bases) {
            int a = Integer.parseInt(parts[0], base);
            int b = Integer.parseInt(parts[2], base);
            int result = parts[1].equals("+") ? a + b : a - b;
            results.add(Integer.toString(result, base));
        }
        
        if (results.size() == 1) {
            return exp.replace("X", results.iterator().next());
        } else {
            return exp.replace("X", "?");
        }
    }
}
