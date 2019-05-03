package Programmers.summer2017.no4;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(11, new int[]{4, 11}, 1));
        System.out.println(solution(16, new int[]{9}, 2));
        System.out.println(solution(6, new int[]{2}, 2));
        System.out.println(solution(6, new int[]{4}, 2));
    }

    private static int solution(int n, int[] stations, int w) {
        int answer = 0;

        if (stations[0] - w <= 1 && stations[0] + w >= n) {
            return answer;
        }
        if (stations[0] - 1 - w >= 1) {
            if ((stations[0] - 1 - w) % (w * 2 + 1) == 0) {
                answer = (stations[0] - 1 - w) / (w * 2 + 1);
            } else {
                answer = (stations[0] - 1 - w) / (w * 2 + 1) + 1;
            }
        }

        for (int i = 1; i < stations.length; i++) {
            int num = stations[i] - stations[i - 1] - 2 * w - 1;
            if (num > 0) {
                if (num % (w * 2 + 1) == 0) {
                    answer += num / (w * 2 + 1);
                } else {
                    answer += num / (w * 2 + 1) + 1;
                }
            }
        }

        if (stations[stations.length - 1] + w < n) {
            if ((n - stations[stations.length - 1] - w) != 0 && (n - stations[stations.length - 1] - w) % (w * 2 + 1) == 0) {
                answer += (n - stations[stations.length - 1] - w) / (w * 2 + 1);
            } else {
                answer += (n - stations[stations.length - 1] - w) / (w * 2 + 1) + 1;
            }
        }

        return answer;
    }
}
