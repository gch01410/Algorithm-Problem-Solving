package Programmers.binarysearch.no1;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{120, 110, 140, 150}, 485));
    }

    private static int solution(int[] budgets, int M) {
        int answer = 0;
        int high = M;
        int low = 0;
        int mid = 0;
        int amount = 0;
        int min = M;
        int max = 0;
        int sum = 0;

        for (int budget : budgets) {
            max = Math.max(max, budget);
            sum += budget;
        }
        if (sum <= M) {
            return max;
        }

        while (amount != M && (high - low) != 1) {
            amount = 0;
            mid = (high + low) / 2;
            for (int budget : budgets) {
                if (mid <= budget) {
                    amount += mid;
                } else {
                    amount += budget;
                }
            }

            if (amount < M) {
                low = mid;
                if (min >= M - amount) {
                    min = M - amount;
                    answer = mid;
                }
            } else {
                high = mid;
            }
        }

        return answer;
    }
}
