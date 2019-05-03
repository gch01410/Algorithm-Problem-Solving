package Programmers.cache;

import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution(3,new String[]{"Jeju", "Pangyo", "Seoul","NewYork","LA","Jeju","Pangyo", "Seoul", "NewYork", "LA"}));
    }

    private static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String, Boolean> map = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String cite = cities[i].toLowerCase();

            if (map.containsKey(cite)) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).equals(cite)) {
                        list.remove(j);
                        list.add(cite);
                    }
                }
                answer += 1;

            } else {
                if (cacheSize == 0){
                    answer+=5;
                    continue;
                }

                if (list.size() == cacheSize) {
                    map.remove(list.removeFirst());
                    list.add(cite);
                    map.put(cite, true);
                } else {
                    list.add(cite);
                    map.put(cite, true);
                }
                answer += 5;

            }

        }

        return answer;
    }
}
