package Programmers.stackQueue.no3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }


    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int weightSum = 0;
        ArrayList<Truck> truckList = new ArrayList<>();
        ArrayList<Truck> inTheBridge = new ArrayList<>();
        ArrayList<Truck> answerList = new ArrayList<>();

        for (int anArray : truck_weights) {
            truckList.add(new Truck(anArray));
        }

        while (answerList.size() < truck_weights.length) {
            boolean flag = false;
            answer++;
            if (!truckList.isEmpty() && weightSum + truckList.get(0).getWeight() <= weight) {
                inTheBridge.add(truckList.get(0));
                weightSum += truckList.get(0).getWeight();
                truckList.remove(0);
            }

            for (Truck truck : inTheBridge) {
                truck.plusCount();
                if (truck.getCount() == bridge_length) {
                    flag = true;
                    weightSum -= truck.getWeight();
                    answerList.add(truck);
                }
            }
            if (flag) {
                inTheBridge.remove(0);
            }
        }

        return answer;
    }
}

class Truck {
    private int weight;
    private int count;

    public Truck(int weight) {
        this.weight = weight;
        count = 0;
    }

    public int getWeight() {
        return weight;
    }

    public int getCount() {
        return count;
    }

    public void plusCount() {
        count++;
    }
}
