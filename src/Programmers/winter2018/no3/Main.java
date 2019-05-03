package Programmers.winter2018.no3;

public class Main {
    private static int[] sumCookie;

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 1, 2, 3}));
        System.out.println(solution(new int[]{1, 2, 4, 5}));
    }

    private static int solution(int[] cookie) {
        int answer = 0;
        sumCookie = new int[cookie.length + 1];

        for (int i = 1; i < sumCookie.length; i++) {
            sumCookie[i] = sumCookie[i - 1] + cookie[i - 1];
        }

        for (int l = 0; l < cookie.length - 1; l++) {
            for (int r = cookie.length - 1; r > l; r--) {
                answer = Math.max(answer, cal(l, r));
            }
        }

        return answer;
    }

    private static int cal(int l, int r) {
        int son1, son2, mid;
        int low = l, high = r;

        while (high > low + 1) {
            mid = (high + low) / 2;
            son1 = sumCookie[mid + 1] - sumCookie[l];
            son2 = sumCookie[r + 1] - sumCookie[mid + 1];

            if (son1 == son2) {
                return son1;
            } else if (son1 > son2) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
