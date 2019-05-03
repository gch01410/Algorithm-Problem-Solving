package Backjoon_online_judge.no17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int subin = Integer.parseInt(st.nextToken());
        int kebin = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int[] visit1 = new int[500000];
        int[] visit2 = new int[500000];

        queue.add(subin);
        int time = 0;

        while (kebin <= 500000) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int nowSubin = queue.poll();

                if (nowSubin == kebin) {
                    System.out.println(time);
                    return;
                }

                if (time % 2 == 0) {
                    visit1[nowSubin] = 1;
                } else {
                    visit2[nowSubin] = 1;
                }

                if (time % 2 == 0) {
                    if (nowSubin * 2 <= 500000 && visit1[nowSubin * 2] == 0) {
                        queue.add(nowSubin * 2);
                    }
                    if (nowSubin + 1 <= 500000 && visit1[nowSubin + 1] == 0) {
                        queue.add(nowSubin + 1);
                    }
                    if (nowSubin - 1 >= 0 && visit1[nowSubin - 1] == 0) {
                        queue.add(nowSubin - 1);
                    }
                } else {
                    if (nowSubin * 2 <= 500000 && visit2[nowSubin * 2] == 0) {
                        queue.add(nowSubin * 2);
                    }
                    if (nowSubin + 1 <= 500000 && visit2[nowSubin + 1] == 0) {
                        queue.add(nowSubin + 1);
                    }
                    if (nowSubin - 1 >= 0 && visit2[nowSubin - 1] == 0) {
                        queue.add(nowSubin - 1);
                    }
                }
            }

            time++;
            kebin += time;
        }
        System.out.println(-1);
    }
}
