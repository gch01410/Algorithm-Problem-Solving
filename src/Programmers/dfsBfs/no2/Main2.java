package Programmers.dfsBfs.no2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    private static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        System.out.println(solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
//        System.out.println(solution(3,new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }

    private static int solution(int n, int[][] computers) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0;i<computers.length;i++) {
            if (!set.contains(i)) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int num = queue.poll();
                    for (int j = 0; j < computers.length; j++) {
                        if (computers[num][j] == 1 && !set.contains(j)) {
                            set.add(j);
                            queue.add(j);
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}
