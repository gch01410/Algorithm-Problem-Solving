package Backjoon_online_judge.no16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] s2d2;
    static int[][] map;
    static Deque<Tree> trees = new LinkedList<>();
    static Deque<Tree> dieTrees = new LinkedList<>();
    static Deque<Tree> liveTrees = new LinkedList<>();
    static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        s2d2 = new int[n + 1][n + 1];
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                s2d2[i][j] = Integer.parseInt(st.nextToken());
                map[j][i] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }

        for (int i = 0; i < k; i++) {
            spring();
            summer();
            fall();
            winter();
        }
        System.out.print(trees.size());
    }

    private static void spring() {
        while (!trees.isEmpty()) {
            Tree tree = trees.poll();
            if (tree.age <= map[tree.x][tree.y]) {
                map[tree.x][tree.y] -= tree.age;
                tree.age++;
                liveTrees.add(tree);
            } else {
                dieTrees.add(tree);
            }
        }
    }

    private static void summer() {
        while (!dieTrees.isEmpty()) {
            Tree tree = dieTrees.poll();
            map[tree.x][tree.y] += tree.age / 2;
        }
    }

    private static void fall() {
        while (!liveTrees.isEmpty()) {
            Tree tree = liveTrees.poll();
            if (tree.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nextX = tree.x + dirX[i];
                    int nextY = tree.y + dirY[i];

                    if (nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= n) {
                        trees.addFirst(new Tree(nextX, nextY, 1));
                    }
                }
            }
            trees.add(tree);
        }
    }

    private static void winter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] += s2d2[i][j];
            }
        }
    }
}

class Tree {
    int y;
    int x;
    int age;

    public Tree(int y, int x, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
}
