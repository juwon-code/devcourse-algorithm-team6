public class Solution {
    String video_len;
    String pos;
    String op_start;
    String op_end;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        this.video_len = video_len;
        this.pos = pos;
        this.op_start = op_start;
        this.op_end = op_end;

        for (String command : commands) {
            this.pos = calTime(command);
        }
        return this.pos;
    }

    public String calTime(String command) {
        int ct = convertToSeconds(pos);

        if (ct < 0) {
            ct = 0;
        } else if (ct >= convertToSeconds(op_start) &&
                ct <= convertToSeconds(op_end)) {
            ct = convertToSeconds(op_end);
        } else if (ct > convertToSeconds(video_len)) {
            ct = convertToSeconds(video_len);
        }

        if (command.equals("next")) {
            ct += 10;
        } else if (command.equals("prev")) {
            ct -= 10;
        }

        if (ct < 0) {
            ct = 0;
        } else if (ct >= convertToSeconds(op_start) &&
                ct <= convertToSeconds(op_end)) {
            ct = convertToSeconds(op_end);
        } else if (ct > convertToSeconds(video_len)) {
            ct = convertToSeconds(video_len);
        }

        return convertToTimeString(ct);
    }

    public static int convertToSeconds(String timeString) {
        String[] parts = timeString.split(":");

        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);

        return minutes * 60 + seconds;
    }

    public static String convertToTimeString(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
