package Programmers.dfsBfs.no3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static int answer = 51;

    public static void main(String[] args) {
//        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    private static int solution(String begin, String target, String[] words) {

        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> usedList = new ArrayList<>();

        dfs(list, usedList, begin, target, 0);
        if (answer == 51) {
            answer = 0;
        }

        return answer;
    }

    private static void dfs(ArrayList<String> words, ArrayList<String> usedList, String begin, String target, int n) {
        ArrayList<String> nextList = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (check(begin, words.get(i)) && check2(words.get(i), usedList)) {
                nextList.add(words.get(i));
            }
        }

        if (begin.equals(target)) {
            answer = Math.min(answer, n);
        }
        if (nextList.size() == 0) {
            return;
        }

        for (int i = 0; i < nextList.size(); i++) {
            ArrayList<String> wordsList = new ArrayList<>(usedList);
            wordsList.add(nextList.get(i));
            dfs(words, wordsList, nextList.get(i), target, n + 1);
        }
    }

    private static boolean check(String str, String words) {
        int count = 0;
        for (int i = 0; i < words.length(); i++) {
            if (str.charAt(i) != words.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean check2(String str, ArrayList<String> words) {
        for (String word : words) {
            if (str.equals(word)) {
                return false;
            }
        }
        return true;
    }
}
