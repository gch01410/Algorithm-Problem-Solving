package Backjoon_online_judge.no16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Fish> fish = new LinkedList<>();
        int[] dirX = {0, -1, 1, 0};
        int[] dirY = {-1, 0, 0, 1};
        boolean[][] visit = new boolean[n][n];
        int sharkSize = 2;
        int sharkCount = 0;
        int sharkX = 0;
        int sharkY = 0;
        int count = -1;
        int time = 0;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
                if (map[j][i] == 9) {
                    sharkX = j;
                    sharkY = i;
                }
            }
        }

        queue.add(sharkX);
        queue.add(sharkY);
        visit[sharkX][sharkY] = true;
        map[sharkX][sharkY] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size() / 2;
            count++;

            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                int y = queue.poll();

                if (map[x][y] > 0 && map[x][y] < sharkSize) {
                    fish.add(new Fish(x, y));
                }

                for (int j = 0; j < 4; j++) {
                    int nextX = x + dirX[j];
                    int nextY = y + dirY[j];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && map[nextX][nextY] <= sharkSize && !visit[nextX][nextY]) {
                        queue.add(nextX);
                        queue.add(nextY);
                        visit[nextX][nextY] = true;
                    }
                }
            }

            if (!fish.isEmpty()) {
                Collections.sort(fish);
                Fish dieFish = fish.get(0);
                int x = dieFish.getX();
                int y = dieFish.getY();

                map[x][y] = 0;
                sharkX = x;
                sharkY = y;
                sharkCount++;
                if (sharkCount == sharkSize) {
                    sharkSize++;
                    sharkCount = 0;
                }
                queue.clear();
                fish.clear();
                queue.add(sharkX);
                queue.add(sharkY);
                time += count;
                count = -1;
                visit = new boolean[n][n];
                visit[sharkX][sharkY] = true;
            }

        }
        System.out.println(time);
    }

}

class Fish implements Comparable<Fish> {
    int x;
    int y;

    public Fish(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Fish o) {
        if (this.y < o.y) {
            return -1;
        } else if (this.y == o.y) {
            if (this.x < o.x) {
                return -1;
            }
        }
        return 1;
    }
}