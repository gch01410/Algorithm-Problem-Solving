package Programmers.heap.no1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    private static int solution(int[] scoville, int K) {
        int answer = 0;
        Heap heap = new Heap(scoville.length);
        for (int index : scoville) {
            heap.insert(index);
        }

        while (heap.getMin() < K) {
            if (heap.getSize() == 0){
                answer = -1;
                break;
            }
            answer++;
            int min1 = heap.remove();
            int min2 = heap.remove();
            heap.insert(min1 + min2 * 2);
        }

        return answer;
    }

    static class Heap {
        private int size;
        private int[] data;

        public Heap(int length) {
            size = 0;
            data = new int[length];
        }

        public void insert(int item) {
            if (size >= data.length) {
                return;
            }
            int pointer = size;
            data[size++] = item;
            while (pointer != 0 && data[(pointer - 1) / 2] > data[pointer]) {
                int temp = data[pointer];
                data[pointer] = data[(pointer - 1) / 2];
                data[(pointer - 1) / 2] = temp;
                pointer = (pointer - 1) / 2;
            }
        }

        public int remove() {
            if (size == 0) {
                return -1;
            }
            int item = data[0];
            int pointer = 0;
            data[0] = data[size - 1];
            data[size - 1] = 0;
            size--;
            while (pointer * 2 + 1 < size) {
                if (pointer * 2 + 2 < size && data[pointer * 2 + 1] > data[pointer * 2 + 2]) {
                    if (data[pointer] > data[pointer * 2 + 2]) {
                        int temp = data[pointer * 2 + 2];
                        data[pointer * 2 + 2] = data[pointer];
                        data[pointer] = temp;
                        pointer = pointer * 2 + 2;
                    } else {
                        break;
                    }
                } else {
                    if (data[pointer] > data[pointer * 2 + 1]) {
                        int temp = data[pointer * 2 + 1];
                        data[pointer * 2 + 1] = data[pointer];
                        data[pointer] = temp;
                        pointer = pointer * 2 + 1;
                    } else {
                        break;
                    }
                }
            }
            return item;
        }

        public void print() {
            System.out.println(Arrays.toString(data));
        }

        public int getMin() {
            return data[0];
        }

        public int getSize() {
            return size;
        }
    }
}
