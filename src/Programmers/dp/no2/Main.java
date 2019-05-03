package Programmers.dp.no2;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    private static long solution(int N) {
        long answer = 0;

        int a = 1;
        int b = 1;
        int c = 1;
        if (N == 1) {
            return 4;
        }
        for (int i = 0; i < N - 2; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        answer = 4 * c + 2 * a;

        return answer;
    }
}
