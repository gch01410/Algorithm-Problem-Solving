package Programmers.kakaoblind2017.secret_map;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(solution(1, new int[]{1}, new int[]{0})));
        System.out.println(Arrays.toString(solution(3, new int[]{0, 1, 0}, new int[]{0, 0, 0})));
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = (arr1[i] | arr2[i]);
            answer[i] = convertToString(num[i], n);
        }

        return answer;
    }

    private static String convertToString(int num, int n) {
        String binary = "";
        while (num >= 4) {
            int remainder = num % 2;
            if (remainder == 0) {
                binary = " " + binary;
            } else {
                binary = "#" + binary;
            }
            num /= 2;
        }

        if (num == 2) {
            binary = "# " + binary;
        } else if (num == 3) {
            binary = "##" + binary;
        } else if (num == 1) {
            binary = "#" + binary;
        } else {
            binary = " " + binary;
        }

        if (binary.length() != n) {
            int size = binary.length();
            for (int i = 0; i < n - size; i++) {
                binary = " " + binary;
            }
        }

        return binary;
    }
}
