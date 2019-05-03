package Programmers.winter2018.no2;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    private static int solution(String dirs) {
        int answer = 0;
        int[][][] dp = new int[11][11][4];
        int x = 5, y = 5;

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            switch (dir) {
                case 'U':
                    if (y + 1 <= 10) {
                        if (dp[x][y][0] == 0) {
                            dp[x][y][0] = 1;
                            dp[x][y + 1][1] = 1;
                            answer++;
                        }
                        y++;
                    }
                    break;
                case 'D':
                    if (y - 1 >= 0) {
                        if (dp[x][y][1] == 0) {
                            dp[x][y][1] = 1;
                            dp[x][y - 1][0] = 1;
                            answer++;
                        }
                        y--;
                    }
                    break;
                case 'R':
                    if (x + 1 <= 10) {
                        if (dp[x][y][2] == 0) {
                            dp[x][y][2] = 1;
                            dp[x + 1][y][3] = 1;
                            answer++;
                        }
                        x++;
                    }
                    break;
                case 'L':
                    if (x - 1 >= 0) {
                        if (dp[x][y][3] == 0) {
                            dp[x][y][3] = 1;
                            dp[x - 1][y][2] = 1;
                            answer++;
                        }
                        x--;
                    }
            }
        }

        return answer;
    }
}
