package SW_Expert_Academy.no5653;

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

        int test_case = Integer.parseInt(st.nextToken());
        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            Cell[][] map = new Cell[500][500];
            int[] dirX = {0, 0, -1, 1};
            int[] dirY = {-1, 1, 0, 0};

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    int life = Integer.parseInt(st.nextToken());
                    map[250 + j][250 + i] = new Cell(250 + j, 250 + i, life);

                }
            }

        }
    }
}

class Cell {
    int x;
    int y;
    int life;
    int originalLife;

    public Cell(int x, int y, int life) {
        this.x = x;
        this.y = y;
        this.life = life * 2;
        this.originalLife = life;
    }

    public int time() {
        life--;
        if (life == originalLife) {
            return 1;
        } else if (life == 0) {
            return 2;
        } else {
            return 3;
        }
    }

}