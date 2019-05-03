package Programmers.entiresearch.no2;

import java.util.HashMap;

public class Main {
    private static int answer;

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    private static int solution(String numbers) {
        char[] number = numbers.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char anArray : number) {
            if (map.containsKey(anArray)) {
                map.put(anArray, map.get(anArray) + 1);

            } else {
                map.put(anArray, 1);
            }
        }

        char[] typeOfCard = new char[map.size()];
        int[] numberOfCard = new int[map.size()];
        int i = 0;

        for (char anArray : map.keySet()) {
            typeOfCard[i] = anArray;
            numberOfCard[i] = map.get(anArray);
            i++;
        }

        dfs("", numbers.length(), typeOfCard, numberOfCard);
        return answer;
    }

    private static void dfs(String str, int size, char[] types, int[] cards) {
        if (size < 0) {
            return;
        }

        if (!str.equals("")) {
            if (isPrime(str) && str.charAt(0) != '0') {
                answer++;
            }
        }

        for (int i = 0; i < types.length; i++) {
            if (cards[i] != 0) {
                int[] clone = cards.clone();
                clone[i]--;
                dfs(str + types[i], size - 1, types, clone);
            }
        }
    }

    private static boolean isPrime(String n) {
        int num = Integer.parseInt(n);
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
