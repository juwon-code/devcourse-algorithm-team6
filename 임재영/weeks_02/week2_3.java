package pgs.java.study;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class week2_3 {
    public static void main(String[] args) {
        String[] operations;
        operations = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(Solution3.solution(operations)));
    }
}


class Solution3 {
    public static int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            String oper = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (oper.equals("I")) {
                list.add(num);
                Collections.sort(list);
            } else if (oper.equals("D") && !list.isEmpty()) {
                if (num == -1) {
                    list.remove(0);
                } else if (num == 1) {
                    list.remove(list.size() - 1);
                }
            }
        }

        if (!list.isEmpty()) {
            return new int[]{list.get(list.size() - 1), list.get(0)};
        } else {
            return new int[]{0, 0};
        }
    }
}
