package Programmers.entiresearch.no1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 5})));
    }

    private static int[] solution(int[] answers) {
        int[] answer = {};

        int[] no1 = {1, 2, 3, 4, 5};
        int[] no2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] no3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] num = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == no1[i % 5]) {
                num[0]++;
            }
            if (answers[i] == no2[i % 8]) {
                num[1]++;
            }
            if (answers[i] == no3[i % 10]) {
                num[2]++;
            }
        }

        if (num[0] == num[1] && num[1] == num[2]) {
            answer = new int[]{1, 2, 3};
        } else if (num[2] == num[1] && num[1] > num[0]) {
            answer = new int[]{2, 3};
        } else if (num[2] == num[0] && num[0] > num[1]) {
            answer = new int[]{1, 3};
        } else if (num[0] == num[1] && num[0] > num[2]) {
            answer = new int[]{1, 2};
        } else if (num[0] > num[1] && num[0] > num[2]) {
            answer = new int[]{1};
        } else if (num[1] > num[0] && num[1] > num[2]) {
            answer = new int[]{2};
        } else {
            answer = new int[]{3};
        }

        return answer;
    }
}
