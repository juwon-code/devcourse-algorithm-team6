package juwoncode.devcourse.level1;

public class PSG_동영상_재생기 {
    public static void main(String[] args) {
        System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
        System.out.println(solution("59:59", "59:45", "00:00", "01:00", new String[]{"next"}));
        System.out.println(solution("30:00", "00:11", "05:00", "06:00", new String[]{"prev"}));
        System.out.println(solution("01:00", "00:25", "00:25", "00:25", new String[]{"next"}));
        System.out.println(solution("30:00", "00:08", "00:00", "00:05", new String[]{"prev"}));
    }

    static class Time {
        int minute;
        int second;

        public Time(String timeString) {
            minute = Integer.parseInt(timeString.substring(0, 2));
            second = Integer.parseInt(timeString.substring(3, 5));
        }

        public void moveNext() {
            second += 10;
            if (second >= 60) {
                minute ++;
                second -= 60;
            }
        }

        public void movePrev() {
            second -= 10;
            if (second < 0) {
                minute --;
                second += 60;
            }
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d", minute, second);
        }
    }

    private static Time videoTime;
    private static Time currentTime;
    private static Time openingStartTime;
    private static Time openingEndTime;

    public static String solution(String length, String position, String openingStartAt, String openingEndAt, String[] commands) {
        videoTime = new Time(length);
        currentTime = new Time(position);
        openingStartTime = new Time(openingStartAt);
        openingEndTime = new Time(openingEndAt);

        for (String command : commands) {
            // 명령 실행 전에 체크가 필요하다.
            refreshCurrentTime();
            
            // 커맨드를 실행하여 영상 위치를 이동.
            if (command.equals("next")) {
                currentTime.moveNext();
            } else {
                currentTime.movePrev();
            }
        }

        // 명령 실행 후에 체크가 필요하다.
        refreshCurrentTime();

        return currentTime.toString();
    }

    private static void refreshCurrentTime() {
        if (checkHasNegativeTime()) {
            currentTime.minute = 0;
            currentTime.second = 0;
        }

        if (checkHasOverTime()) {
            currentTime.minute = videoTime.minute;
            currentTime.second = videoTime.second;
        }

        if (checkIsBetweenOpening()) {
            currentTime.minute = openingEndTime.minute;
            currentTime.second = openingEndTime.second;
        }
    }

    private static boolean checkIsBetweenOpening() {
        if (currentTime.minute == openingStartTime.minute && currentTime.minute == openingEndTime.minute) {
            return openingStartTime.second <= currentTime.second && openingEndTime.second > currentTime.second;
        }

        if (currentTime.minute == openingStartTime.minute) {
            return openingStartTime.second <= currentTime.second;
        }

        if (currentTime.minute == openingEndTime.minute) {
            return openingEndTime.second > currentTime.second;
        }

        if (currentTime.minute > openingStartTime.minute
                && currentTime.minute < openingEndTime.minute) {
            return true;
        }

        return false;
    }

    private static boolean checkHasNegativeTime() {
        return currentTime.minute < 0;
    }

    private static boolean checkHasOverTime() {
        return currentTime.minute >= videoTime.minute && currentTime.second > videoTime.second;
    }
}
