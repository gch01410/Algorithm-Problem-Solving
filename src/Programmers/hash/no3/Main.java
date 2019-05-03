package Programmers.hash.no3;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){

    }

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String,Integer> map = new HashMap<>();
        for (String[] cloth : clothes){
            if (map.containsKey(cloth[1])){
                map.put(cloth[1],map.get(cloth[1])+1);
            } else {
                map.put(cloth[1],1);
            }
        }

        for (String str : map.keySet()){
            answer *= map.get(str)+1;
        }

        answer--;

        return answer;
    }
}
