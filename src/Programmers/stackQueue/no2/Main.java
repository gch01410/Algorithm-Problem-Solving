package Programmers.stackQueue.no2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,1,3,2},2));
        System.out.println(solution(new int[]{1,1,9,1,1,1},0));
    }

    private static int solution(int[] priorities, int location) {
        int answer;
        ArrayList<Docu> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < priorities.length; i++) {
            list.add(new Docu(priorities[i], i));
        }

        while (true) {
            boolean flag = true;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(0).getPriority() < list.get(j).getPriority()){
                    list.add(list.remove(0));
                    flag = false;
                    break;
                }
            }
            if (flag){
                Docu printDocu = list.remove(0);
                count++;
                if (printDocu.getLocation() == location){
                    answer = count;
                    break;
                }
            }
        }
        Queue<String> queue = new LinkedList<>();

        return answer;
    }
}

class Docu {
    private int location;
    private int priority;

    public Docu(int priority, int location) {
        this.location = location;
        this.priority = priority;
    }

    public int getLocation() {
        return location;
    }

    public int getPriority() {
        return priority;
    }
}
