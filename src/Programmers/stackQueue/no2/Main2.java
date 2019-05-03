package Programmers.stackQueue.no2;

import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(solution(2,10,new int[]{7,4,5,6}));
        System.out.println(solution(100,100,new int[]{10}));
        System.out.println(solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}));

    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weightSum = 0;
        Queue<Truck> waitingQueue = new LinkedList<>();
        LinkedList<Truck> drivingQueue = new LinkedList<>();
        Queue<Truck> endQueue = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            waitingQueue.add(new Truck(truck_weight));
        }

        while(endQueue.size() != truck_weights.length){
            for(int i=0;i<drivingQueue.size();i++){
                drivingQueue.get(i).driving();
                if(drivingQueue.get(i).getLocation() == bridge_length) {
                    Truck endTruck = drivingQueue.poll();
                    weightSum -= endTruck.getWeight();
                    endQueue.add(endTruck);
                    i--;
                }
            }
            if(!waitingQueue.isEmpty()) {
                Truck now = waitingQueue.peek();
                if (now.getWeight() + weightSum <= weight) {
                    now = waitingQueue.poll();
                    weightSum += now.getWeight();
                    drivingQueue.add(now);
                }
            }
            answer++;
        }
        return answer;
    }

    static class Truck{
        private int weight;
        private int location;
        public Truck(int weight) {
            this.weight = weight;
            location = 0;
        }
        public int getWeight() {
            return this.weight;
        }
        public int getLocation() {
            return location;
        }
        public void driving() {
            location++;
        }
    }
}
