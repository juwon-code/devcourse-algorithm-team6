class Solution {
    
    int[] videoEnd, now, opStart, opEnd;
    
    //String 타입으로 주어진 시간을 int 배열에 나누어 담는 메서드
    int[] intTime(String stringTime) {
        int[] time = new int[2];
        time[0] = Integer.parseInt(stringTime.split(":")[0]);
        time[1] = Integer.parseInt(stringTime.split(":")[1]);
        return time;
    }
    
    //재생위치를 op_end로 바꿔주는 메서드
    void opSkip() {
        if (now[0] > opStart[0] && now[0] < opEnd[0]) {
            now[0] = opEnd[0];
            now[1] = opEnd[1];
        } else if (now[0] == opStart[0] && now[0] < opEnd[0] && now[1] >= opStart[1]) {
            now[0] = opEnd[0];
            now[1] = opEnd[1];
        } else if (now[0] == opEnd[0] && now[0] > opStart[0] && now[1] <= opEnd[1]) {
            now[1] = opEnd[1];
        } else if (now[0] == opStart[0] && now[0] == opEnd[0] && now[1] >= opStart[1] && now[1] <= opEnd[1]) {
            now[1] = opEnd[1];
        }
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        //주어진 String 타입 매개변수들을 intTime 메서드를 사용하여 int 배열로 변환
        videoEnd = intTime(video_len);
        now = intTime(pos);
        opStart = intTime(op_start);
        opEnd = intTime(op_end);
        
        //commands 배열을 순회하며 명령어에 맞는 행동을 수행
        //현재 재생위치가 op_start와 op_end 사이라면 opSkip 메서드를 사용하ㅕ op_end로 이동
        for (String command : commands) {
            opSkip();
            if (command.equals("prev")){
                if (now[1] < 10) {
                    now[0]--;
                    now[1] += 50;
                } else {
                    now[1] -= 10;
                }
                if (now[0] < 0) now = new int[]{0, 0};
            } else {
                if (now[1] > 50) {
                    now[0]++;
                    now[1] -= 50;
                } else {
                    now[1] += 10;
                }
                if (now[0] > videoEnd[0]) {
                    now[0] = videoEnd[0];
                    now[1] = videoEnd[1];
                } else if (now[0] == videoEnd[0] && now[1] > videoEnd[1]) {
                    now[0] = videoEnd[0];
                    now[1] = videoEnd[1];
                }
            }
            opSkip();
        }
        answer = (now[0] < 10 ? "0" + now[0] : now[0]) + ":" + (now[1] < 10 ? "0" + now[1] : now[1]);
        
        return answer;
    }
}
