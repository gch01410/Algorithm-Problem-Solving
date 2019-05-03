package Backjoon_online_judge.no1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        LinkedList<Integer> list = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int head = 0;
        int tail = n - 1;
        int count = 0;

        for (int i = 0; i < m; i++) {
            int target = arr[i];
            int index = list.indexOf(target);

            if (index <= tail - index) {

                while (list.get(head) != target) {
                    list.add(list.removeFirst());
                    count++;
                }
                list.removeFirst();
                tail--;

            } else {

                while (list.get(head) != target) {
                    list.addFirst(list.removeLast());
                    count++;
                }
                list.removeFirst();
                tail--;

            }

        }

        System.out.print(count);
    }
}
