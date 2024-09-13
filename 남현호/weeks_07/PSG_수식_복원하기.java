import java.util.*;

class Solution {
    
    int num1, num2, num3;
    String operator;
    int minimum = 2;

    //가능한 n진법의 최소 n 찾기
    void findMinimumFormation() {
        int[] nums;
        if (num3 == -1) {
            nums = new int[]{num1 / 10, num1 % 10, num2 / 10, num2 % 10};
        } else {
            nums = new int[]{num1 / 10, num1 % 10, num2 / 10, num2 % 10, num3 / 100, (num3 % 100) / 10, num3 % 10};
        }
        for (int num : nums) {
            minimum = Math.max(minimum, num + 1);
        }
    }

    //최소 진법을 기반으로 주어진 수식에서 가능한 진법 찾기
    void findFormation(List<Integer> formation) {
        Iterator<Integer> iterator = formation.iterator();
        while (iterator.hasNext()) {
            int formationNum = iterator.next();
            int realNum1 = Integer.parseInt(Integer.toString(num1), formationNum);
            int realNum2 = Integer.parseInt(Integer.toString(num2), formationNum);
            int realNum3 = Integer.parseInt(Integer.toString(num3), formationNum);
            switch (operator) {
                case "+" -> {
                    if (realNum1 + realNum2 != realNum3) {
                        iterator.remove();
                    }
                }
                case "-" -> {
                    if (realNum1 - realNum2 != realNum3) {
                        iterator.remove();
                    }
                }
            }
        }
    }
    
    public String[] solution(String[] expressions) {
        String[] answer = {};
        
        //X를 포함하는 수식과 포함하지 않는 수식 분리하고 findMinimumFormation 메서드 사용
        List<String[]> includeX = new ArrayList<>();
        List<String[]> notIncludeX = new ArrayList<>();
        for (String expression : expressions) {
            String[] split = expression.split(" ");
            operator = split[1];
            num1 = Integer.parseInt(split[0]);
            num2 = Integer.parseInt(split[2]);
            if (split[4].equals("X")) {
                includeX.add(split);
                num3 = -1;
            } else {
                notIncludeX.add(split);
                num3 = Integer.parseInt(split[4]);
            }
            findMinimumFormation();
        }
        answer = new String[includeX.size()];

        //findFormation 메서드 사용
        List<Integer> formationList = new LinkedList<>();
        for (int i = minimum; i <= 9; i++) formationList.add(i);
        Iterator<Integer> iterator = formationList.iterator();
        for (String[] notIncludeXExpression : notIncludeX) {
            num1 = Integer.parseInt(notIncludeXExpression[0]);
            num2 = Integer.parseInt(notIncludeXExpression[2]);
            num3 = Integer.parseInt(notIncludeXExpression[4]);
            operator = notIncludeXExpression[1];
            findFormation(formationList);
        }

        //구해진 가능 진법들을 적용하여 X값이 여러개 나오는 경우 ?를, 한개라면 그 값을 넣어 answer 수정
        for (int i = 0; i < includeX.size(); i++) {
            String[] includeXExpression = includeX.get(i);
            boolean onlyOneAnswer = true;
            num1 = Integer.parseInt(includeXExpression[0]);
            num2 = Integer.parseInt(includeXExpression[2]);
            num3 = -1;
            operator = includeXExpression[1];
            for (int formation : formationList) {
                int realNum1 = Integer.parseInt(Integer.toString(num1), formation);
                int realNum2 = Integer.parseInt(Integer.toString(num2), formation);
                if (num3 == -1) {
                    switch (operator) {
                        case "+" -> {
                            int realNum3 = realNum1 + realNum2;
                            num3 = Integer.parseInt(Integer.toString(realNum3, formation));
                        }
                        case "-" -> {
                            int realNum3 = realNum1 - realNum2;
                            num3 = Integer.parseInt(Integer.toString(realNum3, formation));
                        }
                    }
                } else if (onlyOneAnswer) {
                    switch (operator) {
                        case "+" -> {
                            onlyOneAnswer = num3 == Integer.parseInt(Integer.toString(realNum1 + realNum2, formation));
                        }
                        case "-" -> {
                            onlyOneAnswer = num3 == Integer.parseInt(Integer.toString(realNum1 - realNum2, formation));
                        }
                    }
                }
            }
            if (onlyOneAnswer) {
                String result = includeXExpression[0] + " " + includeXExpression[1] + " " + includeXExpression[2] + " = " + num3;
                answer[i] = result;
            } else {
                String result = includeXExpression[0] + " " + includeXExpression[1] + " " + includeXExpression[2] + " = ?";
                answer[i] = result;
            }
        }
        
        return answer;
    }
}
