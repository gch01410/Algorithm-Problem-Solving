package Backjoon_online_judge.no10253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int test_case = 0; test_case < t; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double val = a / (double) b;
            long index = 2;
            long result = 0;

            while (index <= 10000) {
                double val2 = 1 / (double) index;

                if (val2 <= val) {
                    val -= val2;
                    result = index;
                }
                index++;

            }
            System.out.println(result);
        }
    }
}
