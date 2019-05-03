package Programmers.summer2018.no2;

public class Main {
    public static void main(String[] args) {
//        System.out.println(solution(new int[][]{{1, 2}, {2, 3}}, 3, 2));
        System.out.println(solution(new int[][]{{4, 4, 3}, {3, 2, 2}, {2, 1, 0}}, 5, 3));
    }

    private static long solution(int[][] land, int P, int Q) {
        long answer = -1;

        long low = 1000000000;
        long high = 0;
        long mid;
        int size = land.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                high = Math.max(high, land[i][j]);
                low = Math.min(low, land[i][j]);
            }
        }

        while (high >= low) {
            mid = (high + low) / 2;
            long midResult = cal(mid, land, P, Q, size);
            long lowResult = cal(mid - 1, land, P, Q, size);
            long highResult = cal(mid + 1, land, P, Q, size);
            if (high == low + 1) {
                if (midResult <= highResult) {
                    answer = midResult;
                    break;
                } else if (midResult > highResult) {
                    answer = highResult;
                    break;
                }
            }
            if (lowResult < midResult && highResult > midResult) {
                high = mid-1;
            } else if (lowResult > midResult && highResult < midResult) {
                low = mid+1;
            } else if (lowResult >= midResult && highResult >= midResult) {
                answer = midResult;
                break;
            }
        }

        return answer;
    }

    private static long cal(long mid, int[][] land, int P, int Q, int size) {
        long result = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (land[i][j] > mid) {
                    result = result + (land[i][j] - mid) * Q;
                } else if (land[i][j] < mid) {
                    result = result + (mid - land[i][j]) * P;
                }
            }
        }
        return result;
    }
}
