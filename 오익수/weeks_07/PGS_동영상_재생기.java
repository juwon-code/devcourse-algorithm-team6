class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int intVideoLen = strToSec(video_len);
        int intPos = strToSec(pos);
        int intOpStart = strToSec(op_start);
        int intOpEnd = strToSec(op_end);

        for (int i = 0; i < commands.length; i++) {
            intPos = skipOpening(intPos, intOpStart, intOpEnd);
            if (commands[i].equals("prev")) {
                intPos = movePrev(intPos);
            } else if (commands[i].equals("next")) {
                intPos = moveNext(intPos, intVideoLen);
            }
            intPos = skipOpening(intPos, intOpStart, intOpEnd);
        }
        return secToStr(intPos);
    }

    public static int strToSec(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    public static String secToStr(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return (minutes < 10 ? "0" : "") + minutes + ":" + (seconds < 10 ? "0" : "") + seconds;
    }

    public static int movePrev(int currentPos) {
        currentPos -= 10;
        if (currentPos < 0) {
            return 0;
        }
        return currentPos;
    }

    public static int moveNext(int currentPos, int videoLength) {
        currentPos += 10;
        if (videoLength - currentPos < 10) {
            return videoLength;
        }
        return currentPos;
    }

    public static int skipOpening(int currentPos, int opStart, int opEnd) {
        if (currentPos >= opStart && currentPos <= opEnd) {
            return opEnd;
        } else {
            return currentPos;
        }
    }
}
