package Programmers.blind2018.muzi;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2}, 5));
        System.out.println(solution(new int[]{5, 6, 2, 5, 2}, 14));
    }

    private static int solution(int[] food_times, long k) {
        int answer = 0;

        long[][] arr = new long[food_times.length][2];

        for (int i = 0; i < food_times.length; i++) {
            arr[i][0] = food_times[i];
            arr[i][1] = i + 1;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] * arr.length > k) {
                if (i != 0) {
                    k -= arr[i - 1][0] * arr.length;
                    index = i;
                    break;
                } else {
                    break;
                }
            }
        }
        long count = 0;
        long mod = k % (arr.length - index);

        for (int i = 0; i < food_times.length; i++) {
            if (count == mod) {
                answer = i + 1;
                break;
            }
            if (food_times[i] >= arr[index][0]) {
                count++;
            }
        }

        return answer;
    }
}
