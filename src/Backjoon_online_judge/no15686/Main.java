package Backjoon_online_judge.no15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static ArrayList<Customer> customers = new ArrayList();
    static ArrayList<Store> stores = new ArrayList<>();
    static boolean[] visit = new boolean[14];
    static int result = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
                if (map[j][i] == 1) {
                    customers.add(new Customer(j, i));
                } else if (map[j][i] == 2) {
                    stores.add(new Store(j, i));
                }
            }
        }

        dfs(0, 0);
        System.out.print(result);
    }

    private static void dfs(int index, int count) {
        if (count == m) {
            int sum = 0;
            for (int i = 0; i < customers.size(); i++) {
                int houseX = customers.get(i).x;
                int houseY = customers.get(i).y;
                int dist = 1000000;
                for (int j = 0; j < stores.size(); j++) {
                    if (visit[j]) {
                        int storeX = stores.get(j).x;
                        int storeY = stores.get(j).y;
                        dist = Math.min(dist, Math.abs(houseX - storeX) + Math.abs(houseY - storeY));
                    }
                }
                sum += dist;
            }
            result = Math.min(result, sum);
            return;
        }
        else if (stores.size() - index < m - count) {
            return;
        }


        visit[index] = true;
        dfs(index + 1, count + 1);
        visit[index] = false;
        dfs(index + 1, count);
    }
}

class Customer {
    int x;
    int y;

    public Customer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Store {
    int x;
    int y;

    public Store(int x, int y) {
        this.x = x;
        this.y = y;
    }
}