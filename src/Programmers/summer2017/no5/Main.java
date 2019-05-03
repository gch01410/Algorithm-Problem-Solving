package Programmers.summer2017.no5;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(5000));
    }

    private static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}
