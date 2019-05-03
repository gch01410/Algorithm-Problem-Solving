package Backjoon_online_judge.no2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] dirX = new int[]{0, 0, -1, 1};
        int[] dirY = new int[]{-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < n; j++) {
                map[j][i] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    map[i][j] = 0;
                    int count = 0;

                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        int x = arr[0];
                        int y = arr[1];
                        count++;

                        for (int k = 0; k < 4; k++) {
                            int nextX = x + dirX[k];
                            int nextY = y + dirY[k];

                            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && map[nextX][nextY] == 1) {
                                queue.add(new int[]{nextX, nextY});
                                map[nextX][nextY] = 0;
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append("\n");
        Collections.sort(list);

        for (int num : list) {
            sb.append(num).append("\n");
        }

        System.out.println(sb.toString());
    }
}
