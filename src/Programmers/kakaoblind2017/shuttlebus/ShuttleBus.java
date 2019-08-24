package Programmers.kakaoblind2017.shuttlebus;

import java.util.ArrayList;
import java.util.List;

public class ShuttleBus {
    public static void main(String[] args) {
        System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(solution(1, 1, 1, new String[]{"23:59"}));
        System.out.println(solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }

    private static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int conTime;

        int currentTime = 9 * 60;
        int lastBusTime = currentTime + (n - 1) * t;
        List<Integer> times = new ArrayList<>();

        for (String time : timetable) {
            int hour = Integer.parseInt(time.split(":")[0]);
            int minute = Integer.parseInt(time.split(":")[1]);
            times.add(hour * 60 + minute);
        }

        times.sort(Integer::compareTo);

        for (int i = 0; i < times.size(); i++) {
            if (times.get(i) > lastBusTime) {
                times.remove(i);
                i--;
            }
        }


        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                if (times.size() >= m) {
                    conTime = times.get(m - 1) - 1;
                    answer = convertToTime(conTime);
                    break;
                }
                answer = convertToTime(currentTime);
                break;
            }


            for (int j = 0; j < m; j++) {
                if (times.size() == 0) {
                    break;
                }
                if (currentTime >= times.get(0)) {
                    times.remove(0);
                } else {
                    break;
                }
            }

            currentTime += t;
        }

        return answer;
    }

    private static String convertToTime(int time) {
        String hour = String.valueOf(time / 60);
        String minute = String.valueOf(time % 60);

        hour = (hour.length() == 1) ? "0" + hour : hour;
        minute = (minute.length() == 1) ? "0" + minute : minute;

        return hour + ":" + minute;
    }
}
