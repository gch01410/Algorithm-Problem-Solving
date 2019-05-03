package Programmers.summer2018.no3;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }

    private static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int num = 0;
        int order = 0;
        HashMap<String, Boolean> map = new HashMap<>();
        map.put(words[0], true);

        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0) && !map.containsKey(words[i])) {
                map.put(words[i], true);
                continue;
            }
            num = i % n + 1;
            order = i / n + 1;
            break;
        }

        answer[0] = num;
        answer[1] = order;

        return answer;
    }
}
