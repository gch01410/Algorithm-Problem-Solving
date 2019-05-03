package Programmers.sort.no2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{6,10,2}));
//        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
//        System.out.println(solution(new int[]{1000,0,0,0}));
//        System.out.println(solution(new int[]{0,1000,0,0}));
//        System.out.println(solution(new int[]{0,0,1000,001}));
//        System.out.println(solution(new int[]{1000,110,11,10,111}));
//        System.out.println(solution(new int[]{11,112,111,212}));
//        System.out.println(solution(new int[]{12,121}));
//        System.out.println(solution(new int[]{21,212}));
    }

    private static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Number> list = new ArrayList<>();


        for (int i = 0; i < numbers.length; i++) {
            list.add(new Number(numbers[i]));
        }

        Collections.sort(list);

        for (Number num : list) {
            answer.append(Integer.toString(num.getNum()));
        }

        if (answer.charAt(0) == '0'){
            answer = new StringBuilder("0");
        }

        return answer.toString();
    }

    private static int firstDigit(int num) {
        if (num == 1000) {
            return 1;
        } else if (num >= 100) {
            return num / 100;
        } else if (num >= 10) {
            return num / 10;
        } else {
            return num;
        }
    }

    private static int secondDigit(int num) {
        if (num == 1000) {
            return 0;
        } else if (num >= 100) {
            return num / 10 % 10;
        } else if (num >= 10) {
            return num % 10;
        } else {
            return num;
        }
    }

    private static int thirdDigit(int num) {
        if (num == 1000) {
            return 0;
        } else if (num >= 100) {
            return num % 10;
        } else if (num >= 10) {
            return num % 10;
        } else {
            return num;
        }
    }

    static class Number implements Comparable<Number> {
        private int num;

        public Number(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Number o) {
            if (firstDigit(num) > firstDigit(o.num)) {
                return -1;
            } else if (firstDigit(num) == firstDigit(o.num)) {
                if (secondDigit(num) > secondDigit(o.num)) {
                    return -1;
                } else if (secondDigit(num) == secondDigit(o.num)) {
                    if (thirdDigit(num) > thirdDigit(o.num)) {
                        return -1;
                    } else if (thirdDigit(num) == thirdDigit(o.num)) {
                        if (num < o.num) {
                            return -1;
                        }
                    }
                }
            }
            return 1;
        }
    }
}