package Programmers.dfsBfs.no1;

public class Main {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    private static int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(numbers, target, 0, true, 0);
        dfs(numbers, target, 0, false, 0);

        answer = count;

        return answer;
    }

    private static void dfs(int[] numbers, int target, int n, Boolean plus, int sum) {
        if (n == numbers.length) {
            return;
        }
        if (plus) {
            sum += numbers[n];
        } else {
            sum -= numbers[n];
        }
        if (n + 1 == numbers.length && sum == target) {
            count++;
            return;
        }

        dfs(numbers, target, n + 1, true, sum);
        dfs(numbers, target, n + 1, false, sum);

    }

}
