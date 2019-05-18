package Backjoon_online_judge.no1697;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = -1;
        boolean[] visit = new boolean[100001];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                visit[pos] = true;

                if (pos == k) {
                    System.out.print(count);
                    return;
                }

                if (pos - 1 >= 0 && !visit[pos - 1]) {
                    queue.add(pos - 1);
                }
                if (pos * 2 <= 100000 && !visit[pos * 2]) {
                    queue.add(pos * 2);
                }
                if (pos + 1 <= 100000 && !visit[pos + 1]) {
                    queue.add(pos + 1);
                }
            }
        }
    }
}
