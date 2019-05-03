package Programmers.teepsdown2017.no3;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
        System.out.println(solution(8, 1, 8));
        System.out.println(solution(4, 1, 4));
        System.out.println(solution(64, 1, 64));
    }

    private static int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}
