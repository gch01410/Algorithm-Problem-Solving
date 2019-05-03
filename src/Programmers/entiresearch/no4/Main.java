package Programmers.entiresearch.no4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    private static int[] solution(int brown, int red) {
        int[] answer = new int[2];

        boolean flag = false;

        for (int i = 0; i <= (brown / 2 - 1); i++) {
            for (int j = 0; j <= (red + 2); j++) {
                if (i * j == (brown + red) && i + j == (brown + 4) / 2) {
                    if (i >= j) {
                        answer[0] = i;
                        answer[1] = j;
                    } else {
                        answer[1] = i;
                        answer[0] = j;
                    }
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        return answer;
    }
}
