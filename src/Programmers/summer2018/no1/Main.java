package Programmers.summer2018.no1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        System.out.println(solution(new int[]{2,2,2,2}, new int[]{1,1,1,1}));
    }

    private static int solution(int[] A, int[] B) {
        int answer = 0;
        int j = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            while (j < B.length) {
                if (A[i] < B[j]) {
                    answer++;
                    j++;
                    break;
                } else {
                    j++;
                }
            }
        }

        return answer;
    }
}
