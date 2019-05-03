package Backjoon_online_judge.no1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        while (l <= 100) {
            int mid = n / l;
            for (int i = -l + 1; i <= 0; i++) {
                int sum = 0;
                int index = i;
                int[] arr = new int[l];

                if (mid + index < 0) {
                    continue;
                }
                for (int j = 0; j < l; j++) {
                    sum += (mid + index);
                    arr[j] = mid + index;
                    index++;
                }

                if (sum == n) {
                    for (int j = 0; j < l; j++) {
                        System.out.print(arr[j] + " ");
                    }
                    return;
                }

            }
            l++;
        }
        System.out.print(-1);
    }
}
