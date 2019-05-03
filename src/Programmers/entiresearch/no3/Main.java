package Programmers.entiresearch.no3;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}));
    }

    private static int solution(int[][] baseball) {
        int answer = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    boolean flag = false;
                    for (int[] array : baseball) {
                        if (!check(array, i, j, k)) {
                            flag = false;
                            break;
                        } else {
                            flag = true;
                        }
                    }
                    if (flag) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean check(int[] array, int i, int j, int k) {
        int strike = 0;
        int ball = 0;
        int thirdDigit = array[0] / 100;
        int secondDigit = array[0] / 10 % 10;
        int firstDigit = array[0] % 10;

        if (i==j || j==k || i==k){
            return false;
        }

        if (thirdDigit == i) {
            strike++;
        } else if (thirdDigit == j || thirdDigit == k) {
            ball++;
        }
        if (secondDigit == j) {
            strike++;
        } else if (secondDigit == i || secondDigit == k) {
            ball++;
        }
        if (firstDigit == k) {
            strike++;
        } else if (firstDigit == i || firstDigit == j) {
            ball++;
        }
        return strike == array[1] && ball == array[2];
    }
}