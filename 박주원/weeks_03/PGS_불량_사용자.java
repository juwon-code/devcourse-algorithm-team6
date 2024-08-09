/**
 * title : 불량 사용자
 */

package juwoncode.devcourse.level3;

import java.util.*;

public class PGS_불량_사용자 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "abc1**"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    public static int solution(String[] userIds, String[] bannedIds) {
        // 가능성이 있는 밴 아이디 리스트를 담을 리스트를 생성.
        List<List<String>> mainList = new ArrayList<>();

        // 밴 아이디일 가능성이 있는 회원 아이디를 리스트에 삽입.
        for (String bannedId : bannedIds) {
            List<String> subList = new ArrayList<>();
            for (String userId : userIds) {
                if (compare(userId, bannedId)) {
                    subList.add(userId);
                }
            }
            mainList.add(subList);

        }

        // 중복이 제거된 조합을 담을 셋을 생성.
        Set<Set<String>> mainSet = new HashSet<>();

        // 조합을 찾고 셋에 삽입하는 메소드를 재귀 호출.
        findCombinations(mainList, new ArrayList<>(), mainSet, 0);

        // 조합의 개수 반환.
        return mainSet.size();
    }

    private static void findCombinations(List<List<String>> mainList, List<String> currents, Set<Set<String>> mainSet, int index) {
        // 인덱스가 메인 크기와 일치할 경우 셋에 삽입하고 재귀 종료.
        if (index == mainList.size()) {
            mainSet.add(new HashSet<>(currents));
            return;
        }

        // 임시 리스트에 존재하지 않는 아이디일 경우 추가하고 인덱스를 하나 증가시켜 재귀 호출, 최종적으로 추가한 아이디 제거.
        for (String userId : mainList.get(index)) {
            if (!currents.contains(userId)) {
                currents.add(userId);
                findCombinations(mainList, currents, mainSet, index + 1);
                currents.remove(userId);
            }
        }
    }

    private static boolean compare(String userId, String bannedId) {
        // 아이디의 길이가 일치하지 않을 경우 false 반환.
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            char ch1 = userId.charAt(i);
            char ch2 = bannedId.charAt(i);

            // 밴 아이디가 "*"가 아니면서 회원 아이디와 일치하지 않는 경우 false 반환.
            if (ch2 != '*' && ch1 != ch2) {
                return false;
            }
        }

        return true;
    }
}
