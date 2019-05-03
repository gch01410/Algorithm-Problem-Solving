package Programmers.binarysearch.no2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    private static long solution(long n, int[] times) {
        Arrays.sort(times);

        long high = times[times.length - 1] * n;
        long answer = high;
        long low = 1;
        long mid;

        while (high > low + 1) {
            long sum = 0;
            mid = (high + low) / 2;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            if (sum < n) {
                low = mid;
            } else {
                high = mid;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }
}
