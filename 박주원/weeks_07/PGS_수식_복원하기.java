package juwoncode.devcourse.level3;

import java.util.*;

public class PGS_수식_복원하기 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"14 + 3 = 17", "13 - 6 = X", "51 - 5 = 44"})));
        System.out.println(Arrays.toString(solution(new String[]{"1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"})));
        System.out.println(Arrays.toString(solution(new String[]{"10 - 2 = X", "30 + 31 = 101", "3 + 3 = X", "33 + 33 = X"})));
        System.out.println(Arrays.toString(solution(new String[]{"2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "5 - 5 = X"})));
        System.out.println(Arrays.toString(solution(new String[]{"2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "8 + 4 = X"})));
    }

    private static final int TERM_COUNT = 5;
    private static int base;

    public static String[] solution(String[] expressions) {
        // 결과값이 있는 리스트와 모르는 리스트, 진법을 초기화한다.
        List<List<String>> termsList = new ArrayList<>();
        List<List<String>> xTermsList = new ArrayList<>();
        base = 1;

        // 수식을 항을 기준으로 나누고, 각 리스트에 삽입한 후, 최소 진법을 구한다.
        for (String expression : expressions) {
            String[] _expressions = expression.split(" ");

            if (_expressions[4].equals("X")) {
                insertTerms(xTermsList, _expressions);
            } else {
                insertTerms(termsList, _expressions);
            }

            refreshBaseNumber(_expressions);
        }
        base++;

        // 진법을 결과값 있는 수식에 대입하여 유효한 진법을 구해서 리스트에 저장한다.
        List<Integer> acceptableBases = new ArrayList<>();
        for (int i = base; i < 10; i++) {
            boolean isBaseOk = true;
            for (List<String> terms : termsList) {
                String expression = terms.get(1);

                int actual = (expression.equals("+"))
                        ? toDecimalNumber(terms.get(0), i) + toDecimalNumber(terms.get(2), i)
                        : toDecimalNumber(terms.get(0), i) - toDecimalNumber(terms.get(2), i);
                int expect = toDecimalNumber(terms.get(4), i);

                if (actual != expect) {
                    isBaseOk = false;
                    break;
                }
            }

            if (isBaseOk) {
                acceptableBases.add(i);
            }
        }

        // 유효한 진법을 대입하여 X값을 계산하여 문자열 리스트에 삽입한다.
        List<List<String>> actualsList = new ArrayList<>();
        for (int acceptableBase : acceptableBases) {
            List<String> actuals = new ArrayList<>();
            for (List<String> xTerms : xTermsList) {
                String expression = xTerms.get(1);
                int result = (expression.equals("+"))
                        ? toDecimalNumber(xTerms.get(0), acceptableBase) + toDecimalNumber(xTerms.get(2), acceptableBase)
                        : toDecimalNumber(xTerms.get(0), acceptableBase) - toDecimalNumber(xTerms.get(2), acceptableBase);
                actuals.add(String.format("%s %s %s = %d", xTerms.get(0), expression, xTerms.get(2), toBaseNumber(result, acceptableBase)));
            }
            actualsList.add(actuals);
        }

        // 진법의 각 수식에 중복을 검사하고 결과 리스트에 삽입한다.
        List<String> answer = new ArrayList<>();
        int xTermsSize = xTermsList.size();
        for (int i = 0; i < xTermsSize; i++) {
            Set<String> set = new HashSet<>();
            for (List<String> actuals : actualsList) {
                if (i < actuals.size()) {
                    set.add(actuals.get(i));
                }
            }
            // 동일한 결과가 여러 진법에서 나온다면 '?'로 대체한다.
            if (set.size() > 1) {
                answer.add(actualsList.get(0).get(i).replaceFirst("= \\d+", "= ?"));
            } else {
                answer.add(set.iterator().next());
            }
        }

        return answer.toArray(String[]::new);
    }

    // X진법 숫자를 10진법으로 변환하는 메소드.
    private static int toDecimalNumber(String numString, int base) {
        int numberLength = numString.length();
        int[] digits = Arrays.stream(numString.split("")).mapToInt(Integer::parseInt).toArray();
        int decimalNumber = 0;

        for (int i = 0; i < numberLength; i++) {
            decimalNumber += digits[i] * (int) Math.pow(base, numberLength - i - 1);
        }

        return decimalNumber;
    }

    // 10진법을 X진법 숫자로 변환하는 메소드.
    private static int toBaseNumber(int decimalNumber, int base) {
        if (decimalNumber == 0) return 0;
        StringBuilder baseNumber = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            baseNumber.append(remainder);
            decimalNumber /= base;
        }

        return Integer.parseInt(baseNumber.reverse().toString());
    }

    // 자연수 중에 제일 큰 숫자로 진법을 갱신한다.
    private static void refreshBaseNumber(String[] expressions) {
        for (int j = 0; j < TERM_COUNT; j++) {
            if (j % 2 == 0 && !expressions[j].equals("X")) {
                String[] digits = expressions[j].split("");
                base = Math.max(base, Arrays.stream(digits).mapToInt(Integer::parseInt).max().getAsInt());
            }
        }
    }

    // 새로운 항을 삽입한다.
    private static void insertTerms(List<List<String>> termsList, String[] expressions) {
        List<String> inputs = new ArrayList<>(Arrays.asList(expressions));
        termsList.add(inputs);
    }
}