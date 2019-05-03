package Programmers.hash.no4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }

    private static int[] solution(String[] genres, int[] plays) {
        int[] answer;

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> playFirstMap = new HashMap<>();
        HashMap<String, Integer> playSecondMap = new HashMap<>();
        HashMap<String, Integer> indexFirstMap = new HashMap<>();
        HashMap<String, Integer> indexSecondMap = new HashMap<>();
        HashMap<Integer, String> playSumGenreMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
                if (plays[i] > playSecondMap.get(genres[i]) && playFirstMap.get(genres[i]) >= plays[i]) {
                    playSecondMap.put(genres[i], plays[i]);
                    indexSecondMap.put(genres[i], i);
                } else if (playFirstMap.get(genres[i]) < plays[i]) {
                    playSecondMap.put(genres[i], playFirstMap.get(genres[i]));
                    playFirstMap.put(genres[i], plays[i]);
                    indexSecondMap.put(genres[i], indexFirstMap.get(genres[i]));
                    indexFirstMap.put(genres[i], i);
                }
            } else {
                map.put(genres[i], plays[i]);
                playFirstMap.put(genres[i], plays[i]);
                playSecondMap.put(genres[i], 0);
                indexFirstMap.put(genres[i], i);
                indexSecondMap.put(genres[i], -1);
            }
        }

        for (String str : map.keySet()) {
            playSumGenreMap.put(map.get(str), str);
            arrayList.add(map.get(str));
        }

        arrayList.sort(Collections.reverseOrder());

        for (int i = 0; i < arrayList.size(); i++) {
            answerList.add(indexFirstMap.get(playSumGenreMap.get(arrayList.get(i))));
            if (indexSecondMap.get(playSumGenreMap.get(arrayList.get(i))) != -1) {
                answerList.add(indexSecondMap.get(playSumGenreMap.get(arrayList.get(i))));
            }
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
