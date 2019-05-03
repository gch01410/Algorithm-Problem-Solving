package Programmers.sort.no3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }

    private static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int h = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= h) {
                answer = h;
                break;
            }
            h--;
        }


//        int size = citations.length;
//        int h = citations.length;
//
//        while (h != 0) {
//            int count = 0;
//            for (int i = 0; i < size; i++) {
//                if (citations[i] >= h) {
//                    count++;
//                }
//            }
//            if (count >= h) {
//                answer = h;
//                break;
//            }
//            h--;
//        }

        return answer;
    }
}
