import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2]; //결과저장 배열
        ArrayList<Integer> store = new ArrayList<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // 최소 힙
        
        for(String operation : operations){
            String[] ops = operation.split(" "); // 명령어와 숫자를 분리
            int num = Integer.parseInt(ops[1]); // 숫자 변환
            
            if(ops[0].equals("I")){
                // "I" 명령어: 숫자를 최대 힙과 최소 힙에 추가
                maxQueue.add(num); 
                minQueue.add(num);
            } else {
                // "D" 명령어: 숫자에 따라 최대값 또는 최소값 삭제
                if(num == -1)
                    maxQueue.remove(minQueue.poll()); // 최소값을 제거하고 최대 힙에서 해당 값 제거
                else 
                    minQueue.remove(maxQueue.poll()); // 최대값을 제거하고 최소 힙에서 해당 값 제거
            }
        }
        
        // 최대값과 최소값 결정
        answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.peek(); // 최대값이 없는 경우 0
        answer[1] = minQueue.isEmpty() ? 0 : minQueue.peek(); // 최소값이 없는 경우 0
        return answer; // 결과 배열 반환
    }
}
