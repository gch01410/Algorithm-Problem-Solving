package Backjoon_online_judge.no1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] map;
    static int[] dp;
    static int[] visit;
    static int[] hacking;
    static int[] countArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new ArrayList[n + 1];
        dp = new int[n + 1];
        visit = new int[n + 1];
        countArr = new int[n + 1];
        int max = 0;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            hacking = new int[n + 1];
            if (visit[i] == 0) {
                visit[i] = 1;
                dfs(i, i);
            }
            if (max < countArr[i]) {
                max = countArr[i];
                index = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(index);

        for (int i = index + 1; i <= n; i++) {
            if (max == countArr[i]) {
                sb.append(" ").append(i);
            }
        }

        System.out.print(sb.toString());
    }

    private static void dfs(int v, int countArrIndex) {
        hacking[v] = 1;
        countArr[countArrIndex]++;
        for (int i : map[v]) {
            if (hacking[i] == 0) {
                dfs(i, countArrIndex);
            }
        }
    }
}
