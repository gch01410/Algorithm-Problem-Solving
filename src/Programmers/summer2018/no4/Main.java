package Programmers.summer2018.no4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,2,5,4},9));
        System.out.println(solution(new int[]{2,2,3,3},10));
    }

    private static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);

        for (int value : d) {
            if (sum + value > budget){
                break;
            }
            sum += value;
            answer++;
        }

        return answer;
    }
}
