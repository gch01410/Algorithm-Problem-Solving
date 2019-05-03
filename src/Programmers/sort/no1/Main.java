package Programmers.sort.no1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        solution(new int[]{1,5,2,6,3,7,4},new int[][]{{2,5,3},{4,4,1},{1,7,3}});
    }

    public static int[] solution(int[] array, int[][] commands) {

        int size = commands.length;
        int[] answer = new int[size];

        for (int i = 0;i<size;i++){
            int[] clone = new int[commands[i][1]-commands[i][0]+1];

            for (int j=0;j<clone.length;j++){
                clone[j] = array[commands[i][0]-1+j];
            }
            Arrays.sort(clone);
            answer[i] = clone[commands[i][2]-1];
        }

        return answer;
    }
}
