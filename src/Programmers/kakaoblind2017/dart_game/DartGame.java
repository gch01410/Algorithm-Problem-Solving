package Programmers.kakaoblind2017.dart_game;

public class DartGame {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
    }

    private static int solution(String dartResult) {
        int answer = 0;

        String[] scores = new String[3];
        int[] dartScores = new int[4];
        dartScores[0] = 0;
        int count = 0;
        int index = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if (ch == 'S' || ch == 'D' || ch == 'T') {
                if (dartResult.length() != i + 1 && (dartResult.charAt(i + 1) == '#' || dartResult.charAt(i + 1) == '*')) {
                    scores[count++] = dartResult.substring(index, i + 2);
                    index = i + 2;
                } else {
                    scores[count++] = dartResult.substring(index, i + 1);
                    index = i + 1;
                }
            }
        }

        for (int i = 0; i < scores.length; i++) {
            String scr = scores[i];
            if (scr.contains("S")) {
                dartScores[i + 1] = Integer.parseInt(scr.substring(0, scr.indexOf("S")));
            } else if (scr.contains("D")) {
                dartScores[i + 1] = (int) Math.pow(Integer.parseInt(scr.substring(0, scr.indexOf("D"))), 2);
            } else if (scr.contains("T")) {
                dartScores[i + 1] = (int) Math.pow(Integer.parseInt(scr.substring(0, scr.indexOf("T"))), 3);
            }

            if (scr.contains("*")) {
                dartScores[i] *= 2;
                dartScores[i + 1] *= 2;
            } else if (scr.contains("#")) {
                dartScores[i + 1] *= -1;
            }
        }

        for (int dartScore : dartScores) {
            answer += dartScore;
        }

        return answer;
    }
}
