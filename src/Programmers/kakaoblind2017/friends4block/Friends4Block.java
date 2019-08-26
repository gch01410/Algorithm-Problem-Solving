package Programmers.kakaoblind2017.friends4block;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Friends4Block {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }


    private static int solution(int m, int n, String[] board) {
        int answer = 0;
        Set<Point> points = new HashSet<>();

        while (true) {
            points.clear();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (isBomb(j, i, board)) {
                        points.add(new Point(j, i));
                        points.add(new Point(j, i + 1));
                        points.add(new Point(j + 1, i));
                        points.add(new Point(j + 1, i + 1));
                    }
                }
            }
            answer += points.size();
            if (points.size() == 0) {
                break;
            }

            for (Point point : points) {
                char[] chars = board[point.y].toCharArray();
                chars[point.x] = 'b';
                board[point.y] = charArrayConvertToString(chars);
            }

            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    if (board[j].charAt(i) == 'b') {
                        int start = j;
                        for (int k = j - 1; k >= 0; k--) {
                            if (board[k].charAt(i) != 'b') {
                                char[] chars = board[start].toCharArray();
                                chars[i] = board[k].charAt(i);
                                board[start] = charArrayConvertToString(chars);

                                char[] chars1 = board[k].toCharArray();
                                chars1[i] = 'b';
                                board[k] = charArrayConvertToString(chars1);
                                start--;
                            }
                        }

                        break;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean isBomb(int x, int y, String[] board) {
        char ch = board[y].charAt(x);
        if (ch == 'b') {
            return false;
        }
        return board[y].charAt(x + 1) == ch && board[y + 1].charAt(x) == ch && board[y + 1].charAt(x + 1) == ch;
    }

    private static String charArrayConvertToString(char[] chars) {
        StringBuilder str = new StringBuilder();
        for (char aChar : chars) {
            str.append(aChar);
        }
        return str.toString();
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point board = (Point) o;
            return x == board.x &&
                    y == board.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
