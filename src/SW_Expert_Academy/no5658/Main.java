package SW_Expert_Academy.no5658;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            String str = sc.next();
            HashSet<Integer> set = new HashSet<>();
            ArrayList<Integer> list = new ArrayList<>();
            str += str.substring(0, N / 4);
            for (int i = 0; i < N / 4; i++) {
                for (int j = i; j < N + i; j += N / 4) {
                    int num = Integer.parseInt(str.substring(j, j + N / 4), 16);
                    if (!set.contains(num)) {
                        list.add(num);
                        set.add(num);
                    }
                }
            }
            Collections.sort(list);
            System.out.printf("#%d %d\n", test_case, list.get(list.size() - K));
        }
    }
}
