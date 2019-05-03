package Programmers.heap.no4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "D 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }

    private static int[] solution(String[] operations) {
        int[] answer;
        PriorityQueue<MaxQueue> maxList = new PriorityQueue<>();
        PriorityQueue<MinQueue> minList = new PriorityQueue<>();
        for (String operation : operations) {
            char oper = operation.split(" ")[0].charAt(0);
            int data = Integer.parseInt(operation.split(" ")[1]);
            if (oper == 'I') {
                if (maxList.isEmpty()) {
                    System.out.println(data);
                    minList.add(new MinQueue(data));
                } else {
                    maxList.add(new MaxQueue(data));
                }
            } else if (data == 1) {
                if (maxList.isEmpty() && minList.isEmpty()) {
                    continue;
                } else if (maxList.isEmpty()) {
                    int size = minList.size();
                    for (int i = 0; i < size; i++) {
                        maxList.add(new MaxQueue(minList.poll().getValue()));
                    }
//                    System.out.println(maxList.poll().getValue());
                    maxList.poll().getValue();
                } else {
//                    System.out.println(maxList.poll().getValue());
                    maxList.poll().getValue();
                }
            } else {
                if (maxList.isEmpty() && minList.isEmpty()) {
                    continue;
                } else if (maxList.isEmpty()) {
//                    System.out.println(minList.poll().getValue());
                    minList.poll().getValue();
                } else {
                    int size = maxList.size();
                    for (int i = 0; i < size; i++) {
                        minList.add(new MinQueue(maxList.poll().getValue()));
                    }
                    minList.poll().getValue();
//                    System.out.println(minList.poll().getValue());
                }
            }
        }

        if (minList.isEmpty() && maxList.isEmpty()) {
            answer = new int[]{0, 0};
        } else if (maxList.isEmpty()) {
//            System.out.println(minList.toString());
            int min = minList.poll().getValue();
            int size = minList.size();
            for (int i = 0; i < size; i++) {
                maxList.add(new MaxQueue(minList.poll().getValue()));
            }
            int max = maxList.poll().getValue();
            answer = new int[]{max, min};
        } else {
//            System.out.println(maxList.toString());
            int max = maxList.poll().getValue();
            int size = maxList.size();
            for (int i = 0; i < size; i++) {
                minList.add(new MinQueue(maxList.poll().getValue()));
            }
            int min = minList.poll().getValue();
            answer = new int[]{max, min};
        }

        return answer;
    }

    static class MaxQueue implements Comparable<MaxQueue> {
        private int value;

        public MaxQueue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(MaxQueue o) {
            if (this.value > o.value) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    static class MinQueue implements Comparable<MinQueue> {
        private int value;

        public MinQueue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(MinQueue o) {
            if (this.value < o.value) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }
}
