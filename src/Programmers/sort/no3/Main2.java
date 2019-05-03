package Programmers.sort.no3;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,0,6,1,5}));
    }

    private static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int high = citations.length - 1;
        int low = 0;
        int mid = 0;
        while (high>low+1){
            mid = (high+low)/2;
//            System.out.println(mid);
            if(citations[mid]>=mid+1){
                low = mid;
            } else {
                high = mid;
            }
        }
        answer = mid;
        return answer;
    }
}
