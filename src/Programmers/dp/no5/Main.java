package Programmers.dp.no5;

public class Main {
    private static int[][] dp;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 5}, new int[]{2, 4, 1}));
    }

    private static int solution(int[] left, int[] right) {
        int answer = 0;
        dp = new int[left.length + 1][right.length + 1];

//        int leftMax = 0;
//        int leftMin = 2001;
//        int rightMax = 0;
//        int rightMin = 2001;
//        int rightSum = 0;

//        for (int i = 0; i < left.length; i++) {
//            leftMax = Math.max(leftMax, left[i]);
//            leftMin = Math.min(leftMin, left[i]);
//            rightMax = Math.max(rightMax, right[i]);
//            rightMin = Math.min(rightMin, right[i]);
//            rightSum += right[i];
//        }
//
//        if (leftMax > rightMax) {
//            return rightSum;
//        }
//        if (leftMax < rightMin) {
//            return 0;
//        }


        answer = dfs(left, right, 0, 0);

        return answer;
    }

    private static int dfs(int[] left, int[] right, int leftIndex, int rightIndex) {
//        if (left.length == 0 || right.length == 0) {
//            return dp[left.length][right.length] = 0;
//        }
//        if (dp[left.length][right.length] != 0) {
//            return dp[left.length][right.length];
//        }
//
//        int[] removeLeft = new int[left.length - 1];
//        int[] removeRight = new int[right.length - 1];
//
//        System.arraycopy(left, 1, removeLeft, 0, left.length - 1);
//        System.arraycopy(right, 1, removeRight, 0, right.length - 1);
//
//        int leftCardValue = left[0];
//        int rightCardValue = right[0];
//
//        int leftScore = dfs(removeLeft, right);
//        int leftRightScore = dfs(removeLeft, removeRight);
//        int rightScore = 0;
//        if (leftCardValue > rightCardValue) {
//            rightScore = rightCardValue + dfs(left, removeRight);
//        }
//
//        return dp[left.length][right.length] = Math.max(leftScore, Math.max(rightScore, leftRightScore));

        if (leftIndex == left.length || rightIndex == right.length) {
            return 0;
        }
        if (dp[leftIndex][rightIndex] != 0) {
            return dp[leftIndex][rightIndex];
        }
        int leftCardValue = left[leftIndex];
        int rightCardValue = right[rightIndex];

        int leftScore = dfs(left, right, leftIndex + 1, rightIndex);
        int leftRightScore = dfs(left, right, leftIndex + 1, rightIndex + 1);
        int rightScore = 0;
        if (leftCardValue > rightCardValue) {
            rightScore = rightCardValue + dfs(left, right, leftIndex, rightIndex + 1);
        }
        return dp[leftIndex][rightIndex] = Math.max(leftScore, Math.max(rightScore, leftRightScore));
    }
}
