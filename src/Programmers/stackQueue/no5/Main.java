package Programmers.stackQueue.no5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{6, 9, 5, 7, 4})));
    }

    private static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for (int i=0;i<heights.length;i++){
            for (int j=i;j>=0;j--){
                if (heights[i]<heights[j]){
                    answer[i]=j+1;
                    break;
                }
            }
        }

        return answer;
    }
}
