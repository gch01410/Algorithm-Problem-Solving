package Programmers.stackQueue.no4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{40, 93, 30, 55, 60, 65}, new int[]{60, 1, 30, 5, 10, 7})));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int sum = 0;
        ArrayList<Integer> progressList = new ArrayList<>();
        ArrayList<Integer> speedList = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int progress : progresses) {
            progressList.add(progress);
        }

        for (int speed : speeds){
            speedList.add(speed);
        }

        while (sum < progresses.length) {
            int count = 0;
            System.out.println(progressList);
            for (int i = 0; i < progressList.size(); i++) {
                if (progressList.get(i) >= 100) {
                    continue;
                }
                progressList.set(i, progressList.get(i) + speedList.get(i));
            }

            while (progressList.get(0) >= 100) {
                progressList.remove(0);
                speedList.remove(0);
                count++;
                if (progressList.isEmpty()) {
                    break;
                }
            }
            if (count != 0) {
                answerList.add(count);
                sum += count;
            }
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
