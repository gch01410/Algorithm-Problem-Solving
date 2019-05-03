package Programmers.dp.no1;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    }

    private static int solution(int N, int number) {
        int answer = 0;

        HashMap<String, int[]> map = new HashMap<>();
        int k = 1;

        while (k <= 8) {
            if (combine(N,k) == number){

            }
            k++;
        }

        return answer;
    }

    private static int combine(int N, int k) {
        String number="";
        for (int i=0;i<k;i++){
            number += Integer.toString(N);
        }
        return Integer.parseInt(number);
    }
}
