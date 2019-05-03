package Programmers.teepsdown2017.no2;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"ba", "na", "n", "a"}, "banana"));
        System.out.println(solution(new String[]{"app", "ap", "p", "l", "e", "ple", "pp"}, "apple"));
        System.out.println(solution(new String[]{"ba", "an", "nan", "ban", "n"}, "banana"));
    }

    private static int solution(String[] strs, String t) {
        int answer = 1;
        int len = t.length();
        int[] dp = new int[len + 1];
        HashSet<String> set = new HashSet<>();

        for (String str : strs) {
            set.add(str);
        }

        for (int i = 0; i < len; i++){
            dp[i] = len + 1;
        }

        for (int i = len - 1; i >= 0; i--) {
            String tmp = "";
            for (int j = 0; i + j < len && j < 5; j++) {
                tmp += t.substring(i + j, i + j + 1);
                if (set.contains(tmp) && dp[i + j + 1] != len + 1) {
                    dp[i] = Math.min(dp[i], dp[i + j + 1] + 1);
                }
            }
        }

        if (dp[0] == len + 1) {
            answer = -1;
        } else {
            answer = dp[0];
        }

        return answer;
    }
}
