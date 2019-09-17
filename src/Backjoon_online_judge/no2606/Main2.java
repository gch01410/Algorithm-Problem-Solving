package Backjoon_online_judge.no2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int countOfComputer;
    static int countOfPath;
    static int answer;
    static boolean[] visit;
    static boolean[][] paths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        countOfComputer = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        countOfPath = Integer.parseInt(st.nextToken());
        visit = new boolean[countOfComputer + 1];
        paths = new boolean[countOfComputer + 1][countOfComputer + 1];
        answer = 0;
        for (int i = 0; i < countOfPath; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            paths[start][end] = true;
            paths[end][start] = true;
        }

        visit[1] = true;

        dfs(1);
        System.out.print(answer);
    }

    private static void dfs(int n) {
        for (int i = 1; i <= countOfComputer; i++) {
            if (paths[n][i] && !visit[i]) {
                visit[i] = true;
                answer++;
                dfs(i);
            }
        }
    }
}
