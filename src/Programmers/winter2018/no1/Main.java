package Programmers.winter2018.no1;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    private static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Boolean> skillMap;

        for (int i = skill.length() - 1; i > 0; i--) {
            map.put(skill.charAt(i), skill.charAt(i - 1));
        }
        map.put(skill.charAt(0), '0');

        for (String skill_tree : skill_trees) {
            boolean stat = false;
            skillMap = new HashMap<>();
            skillMap.put('0', true);
            for (int i = 0; i < skill_tree.length(); i++) {
                if (map.containsKey(skill_tree.charAt(i))) {
                    if (!skillMap.containsKey(map.get(skill_tree.charAt(i)))) {
                        stat = true;
                        break;
                    } else {
                        skillMap.put(skill_tree.charAt(i), true);
                    }
                }
            }
            if (!stat) {
                answer++;
            }
        }
        return answer;
    }
}
