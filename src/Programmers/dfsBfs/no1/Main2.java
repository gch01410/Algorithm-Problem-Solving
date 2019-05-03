package Programmers.dfsBfs.no1;

public class Main2 {
    private static int answer = 0;

    public static void main(String[] args) {

    }

    private static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, numbers[0]);
        dfs(numbers, target, 0, -numbers[0]);

        return answer;
    }

    private static void dfs(int[] numbers, int target, int n, int num) {
        if (n == numbers.length - 1) {
            if (num == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, n + 1, num + numbers[n + 1]);
        dfs(numbers, target, n + 1, num - numbers[n + 1]);
    }
}
