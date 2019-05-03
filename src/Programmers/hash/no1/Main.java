package Programmers.hash.no1;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : participant) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        for (String str : completion) {
            map.put(str, map.get(str) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
