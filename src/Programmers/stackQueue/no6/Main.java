package Programmers.stackQueue.no6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{498, 501, 470, 489})));
    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i=0;i<prices.length;i++){
            for (int j=i+1;j<prices.length;j++){
                if (prices[i]>prices[j]){
                    answer[i] = j-i;
                    break;
                } else if (j+1 == prices.length) {
                    answer[i] = j-i;
                }
            }
        }

        return answer;
    }
}
