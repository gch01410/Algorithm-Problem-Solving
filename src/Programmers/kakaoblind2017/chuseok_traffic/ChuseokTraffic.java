package Programmers.kakaoblind2017.chuseok_traffic;

public class ChuseokTraffic {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
    }

    private static int solution(String[] lines) {
        int answer = 0;
        int count;
        float[] startTimes = new float[lines.length];
        float[] responseTimes = new float[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String time = line.substring(11);
            String responseTime = time.split(" ")[0];
            String[] splitResponseTime = responseTime.split(":");

            responseTimes[i] = Float.parseFloat(splitResponseTime[0]) * 3600 +
                    Float.parseFloat(splitResponseTime[1]) * 60 +
                    Float.parseFloat(splitResponseTime[2]);
            float processTime = Float.parseFloat(time.split(" ")[1].replace("s", ""));
            startTimes[i] = responseTimes[i] - processTime + 0.001f;
        }

        for (int i = 0; i < lines.length; i++) {
            count = 0;
            for (int j = i; j < lines.length; j++) {
                if (responseTimes[i] + 0.999f >= startTimes[j]) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
