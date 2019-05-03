package Programmers.blind2018.failureRate;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 2, 4, 3, 3})));
    }

    private static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] number = new int[N + 1];
        double[] rate = new double[N];

        for (int i = 0; i < N + 1; i++) {
            for (int stage : stages) {
                number[stage - 1]++;
            }
        }

        HashMap<Integer, Double> map = new HashMap<>();
        int reachNumber = number[N];

        for (int i = N - 1; i >= 0; i--) {
            reachNumber += number[i];
            if (reachNumber == 0){
                rate[i] = 0;
            } else {
                rate[i] = (double) number[i] / reachNumber;
            }
        }

        for (int i = 0; i < N; i++) {
            map.put(i + 1, rate[i]);
        }

        Arrays.sort(rate);

        for (int i = 0; i < N; i++) {
            for (int index : map.keySet()){
                if (rate[N-1-i] == map.get(index)){
                    answer[i] = index;
                    map.remove(index);
                    break;
                }
            }
        }

        return answer;
    }
}
