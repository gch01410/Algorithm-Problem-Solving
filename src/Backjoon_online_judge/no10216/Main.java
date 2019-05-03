package Backjoon_online_judge.no10216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][3];
            boolean[] visit = new boolean[n];
            Queue<int[]> queue = new LinkedList<>();
            int count = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 3; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    queue.add(map[i]);
                    visit[i] = true;
                    count++;
                    if (count == n) {
                        break;
                    }

                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();

                        for (int j = 0; j < n; j++) {
                            if (!visit[j] && isInRange(arr, map[j])) {
                                queue.add(map[j]);
                                visit[j] = true;
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isInRange(int[] arr1, int[] arr2) {
        int x1 = arr1[0];
        int y1 = arr1[1];
        int r1 = arr1[2];
        int x2 = arr2[0];
        int y2 = arr2[1];
        int r2 = arr2[2];

        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) <= (r1 + r2) * (r1 + r2);
    }
}
