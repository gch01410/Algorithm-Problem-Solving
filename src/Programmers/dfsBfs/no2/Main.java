package Programmers.dfsBfs.no2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }

    private static int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        while (map.size() != n) {

            for (int i = 0; i < n; i++) {
                if (!map.containsKey(i)) {
                    queue.add(i);
                    break;
                }
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();
                map.put(now, true);
                for (int i = 0; i < n; i++) {
                    int next = i;
                    if (computers[now][next] == 1 && !map.containsKey(next)) {
                        queue.add(next);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
