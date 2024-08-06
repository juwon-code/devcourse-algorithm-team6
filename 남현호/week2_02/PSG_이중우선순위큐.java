import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        List<Integer> numList = new LinkedList<>();
        for (int i = 0; i < operations.length; i++) {
            String[] operation = operations[i].split(" ");
            switch(operation[0]) {
                    case "I" -> numList.add(Integer.valueOf(operation[1]));
                    case "D" -> {
                        if (numList.isEmpty()) continue;
                        if (operation[1].equals("1")) {
                            numList.remove(numList.stream().max(Integer::compareTo).get());
                        } else {
                            numList.remove(numList.stream().min(Integer::compareTo).get());
                        }
                    }
            }
        }
        
        if (!numList.isEmpty()) {
            answer[0] = numList.stream().max(Integer::compareTo).get();
            answer[1] = numList.stream().min(Integer::compareTo).get();
        }
        
        return answer;
    }
}
