package Backjoon_online_judge.no17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int k;
    static int[][] map;
    static int rowLimit;
    static int colLimit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[100][100];
        rowLimit = 3;
        colLimit = 3;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        while (map[c-1][r-1] != k) {
            if (count > 100) {
                count = -1;
                break;
            }
            count++;
            if (rowLimit >= colLimit) {
                row();
            } else {
                col();
            }
        }

        System.out.print(count);
    }

    private static void row() {
        HashMap<Integer, Num> hashMap = new HashMap<>();
        PriorityQueue<Num> pq = new PriorityQueue<>();
        colLimit = 0;
        for (int i = 0; i < rowLimit; i++) {
            hashMap.clear();
            for (int j = 0; j < rowLimit; j++) {
                if (map[j][i] != 0) {
                    if (hashMap.containsKey(map[j][i])) {
                        hashMap.get(map[j][i]).value++;
                    } else {
                        hashMap.put(map[j][i], new Num(map[j][i], 1));
                    }
                }
            }
            for (int key : hashMap.keySet()) {
                pq.add(hashMap.get(key));
            }

            int index = 0;
            int size = pq.size();
            for (int j = 0; j < size; j++) {
                if (index >= 99) {
                    break;
                }
                Num num = pq.poll();
                map[index][i] = num.key;
                index++;
                map[index][i] = num.value;
                index++;
            }
            colLimit = Math.max(colLimit, index);

            for (int j = index; j < 100; j++) {
                map[j][i] = 0;
            }
        }
    }

    private static void col() {
        HashMap<Integer, Num> hashMap = new HashMap<>();
        PriorityQueue<Num> pq = new PriorityQueue<>();
        rowLimit = 0;
        for (int i = 0; i < colLimit; i++) {
            hashMap.clear();
            for (int j = 0; j < colLimit; j++) {
                if (map[i][j] != 0) {
                    if (hashMap.containsKey(map[i][j])) {
                        hashMap.get(map[i][j]).value++;
                    } else {
                        hashMap.put(map[i][j], new Num(map[i][j], 1));
                    }
                }
            }
            for (int key : hashMap.keySet()) {
                pq.add(hashMap.get(key));
            }

            int index = 0;
            int size = pq.size();
            for (int j = 0; j < size; j++) {
                if (index >= 99) {
                    break;
                }
                Num num = pq.poll();
                map[i][index] = num.key;
                index++;
                map[i][index] = num.value;
                index++;
            }
            rowLimit = Math.max(rowLimit, index);

            for (int j = index; j < 100; j++) {
                map[i][j] = 0;
            }
        }
    }
}

class Num implements Comparable<Num> {
    int key;
    int value;

    Num(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Num o) {
        if (value < o.value) {
            return -1;
        } else if (value == o.value) {
            if (key < o.key) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
