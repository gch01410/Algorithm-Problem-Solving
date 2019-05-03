package Programmers.heap.no2;

public class Main {
    public static void main(String[] args) {
//        System.out.println(solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
        System.out.println(solution(4, new int[]{1, 2, 3, 4}, new int[]{10, 40, 30, 20}, 100));
    }

    private static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        int totalStock = stock;
        for (int supply : supplies) {
            totalStock += supply;
        }

        for (int i = supplies.length - 1; i >= 0; i--) {
            if (totalStock - supplies[i] - dates[i] < k - dates[i]) {
                answer++;
            } else {
                totalStock  -= supplies[i];
            }
        }

        return answer;
    }

    static class Flour implements Comparable<Flour> {
        private int date;
        private int supply;

        Flour(int date, int supply) {
            this.date = date;
            this.supply = supply;
        }

        public int getDate() {
            return date;
        }

        public int getSupply() {
            return supply;
        }

        @Override
        public int compareTo(Flour o) {
            if (this.date > o.date) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
