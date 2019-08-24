package Programmers.kakaoblind2017.newsclustering;

import java.util.*;

public class NewsClustering {
    public static void main(String[] args) {

    }

    private static int solution(String str1, String str2) {
        int answer = 0;
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            if (isAlphabet(str1.charAt(i))) {
                if (isAlphabet(str1.charAt(i+1))) {
                    listA.add(str1.substring(i, i + 2).toLowerCase());
                } else {
                    i++;
                }
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            if (isAlphabet(str2.charAt(i))) {
                if (isAlphabet(str2.charAt(i+1))) {
                    listB.add(str2.substring(i, i + 2).toLowerCase());
                } else {
                    i++;
                }
            }
        }

        union.addAll(listA);
        union.addAll(listB);

        for (String str : listA) {
            if (listB.contains(str)) {
                intersection.add(str);
                listB.remove(str);
            }
        }

        for (String str : intersection) {
            union.remove(str);
        }

        if (union.size() == 0) {
            return 65536;
        }

        answer = (int) ((float) intersection.size() / union.size() * 65536);

        return answer;
    }

    private static boolean isAlphabet(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }
}
