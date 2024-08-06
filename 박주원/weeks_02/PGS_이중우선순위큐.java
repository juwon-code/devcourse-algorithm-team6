/**
 * @title  : 이중우선순위큐
 * @author : juwoncode
 */

package juwoncode.devcourse.level1;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] commands = operation.split(" ");

            if (commands[0].equals("I")) {
                minQueue.add(Integer.valueOf(commands[1]));
                maxQueue.add(Integer.valueOf(commands[1]));
                continue;
            }

            if (minQueue.isEmpty() && maxQueue.isEmpty()) {
                continue;
            }

            if (commands[1].equals("1")) {
                int maxValue = maxQueue.poll();
                minQueue.remove(maxValue);
            } else {
                int minValue = minQueue.poll();
                maxQueue.remove(minValue);
            }
        }

        return maxQueue.isEmpty() && minQueue.isEmpty() ?
                new int[]{0, 0} : new int[]{maxQueue.peek(), minQueue.peek()};
    }
}
