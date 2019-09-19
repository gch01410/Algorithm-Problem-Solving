package Backjoon_online_judge.no1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[100_001];
        queue.add(n);
        visit[n] = true;

        if (n == k) {
            System.out.print(answer);
            return;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                visit[pos] = true;
                if (pos + 1 == k) {
                    System.out.print(answer);
                    return;
                } else if (pos - 1 == k) {
                    System.out.print(answer);
                    return;
                } else if (pos * 2 == k) {
                    System.out.print(answer);
                    return;
                }

                if (pos + 1 <= 100_000 && !visit[pos + 1]) {
                    queue.add(pos + 1);
                }
                if (pos - 1 >= 0 && !visit[pos - 1]) {
                    queue.add(pos - 1);
                }
                if (pos * 2 <= 100_000 && !visit[pos * 2]) {
                    queue.add(pos * 2);
                }
            }
        }
    }
}
