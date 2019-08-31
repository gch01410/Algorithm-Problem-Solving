package Programmers.kakaoblind2017.cache;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(2, new String[]{"Jeju", "Jeju", "Jeju", "Jeju"}));
        System.out.println(solution(2, new String[]{}));
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> cacheCities = new ArrayList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase();
            if (cacheCities.contains(city)) {
                answer += 1;
                cacheCities.remove(city);
                cacheCities.add(city);
            } else {
                if (cacheCities.size() >= cacheSize) {
                    cacheCities.remove(0);
                }
                cacheCities.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}
