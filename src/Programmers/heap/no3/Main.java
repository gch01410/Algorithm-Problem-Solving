package Programmers.heap.no3;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    private static int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        PriorityQueue<Request> requests = new PriorityQueue<>();
        PriorityQueue<Waiting> waitings = new PriorityQueue<>();

        for (int[] job : jobs) {
            requests.add(new Request(job[0], job[1]));
        }

        while (!requests.isEmpty() || !waitings.isEmpty()) {
            while (!requests.isEmpty() && time >= requests.peek().getRequestTime()) {
                Request request = requests.poll();
                waitings.add(new Waiting(request.getRequestTime(), request.getProcessingTime()));
            }

            if (!waitings.isEmpty()) {
                Waiting waiting = waitings.poll();
                answer += (time + waiting.getProcessingTime() - waiting.getRequestTime());
                time += waiting.getProcessingTime();
            } else {
                time = requests.peek().getRequestTime();
            }
        }

        answer /= jobs.length;

        return answer;
    }

    static class Request implements Comparable<Request> {
        private int requestTime;
        private int processingTime;

        public Request(int requestTime, int processingTime) {
            this.requestTime = requestTime;
            this.processingTime = processingTime;
        }

        public int getRequestTime() {
            return requestTime;
        }

        public int getProcessingTime() {
            return processingTime;
        }

        @Override
        public int compareTo(Request o) {
            if (this.requestTime <= o.requestTime) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    static class Waiting implements Comparable<Waiting> {
        private int requestTime;
        private int processingTime;

        public Waiting(int requestTime, int processingTime) {
            this.requestTime = requestTime;
            this.processingTime = processingTime;
        }

        public int getRequestTime() {
            return requestTime;
        }

        public int getProcessingTime() {
            return processingTime;
        }

        @Override
        public int compareTo(Waiting o) {
            if (this.processingTime < o.processingTime) {
                return -1;
            } else if (this.processingTime == o.processingTime) {
                if (this.requestTime <= o.requestTime) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }

    }
}
