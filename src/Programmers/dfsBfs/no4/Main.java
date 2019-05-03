package Programmers.dfsBfs.no4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Main {
    private static ArrayList<Path> answer;

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
//        solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
//        System.out.println(Arrays.toString(solution(new String[][]{{"JFK", "HND"}, {"HND", "IAD"}, {"IAD", "ATL"}})));

    }

    private static String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        ArrayList<String[]> ticketList = new ArrayList<>(Arrays.asList(tickets));
        ArrayList<String> answerList = new ArrayList<>();

        answerList.add("ICN");

        dfs("ICN", ticketList, answerList, tickets.length);

        int index=0;
        for (int i=1;i<answer.size();i++){
            int result = Objects.compare(answer.get(index),answer.get(i),new PathComparator());
            if (result == 1){
                index = i;
            }
        }

        String[] answerArray = new String[tickets.length + 1];

        for (int i = 0; i < tickets.length + 1; i++) {
            answerArray[i] = answer.get(index).getList().get(i);
        }

        return answerArray;
    }

    private static void dfs(String begin, ArrayList<String[]> list, ArrayList<String> answerList, int n) {
        if (n == 0) {
            answer.add(new Path(answerList));
            return;
        }

        ArrayList<String[]> cloneList = new ArrayList<>(list);
        ArrayList<String> arriveList = new ArrayList<>();
        ArrayList<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0].equals(begin)) {
                arriveList.add(list.get(i)[1]);
                indexList.add(i);
            }
        }

        if (arriveList.size() == 0) {
            return;
        }

        for (int i = 0; i < arriveList.size(); i++) {
            ArrayList<String[]> newList = new ArrayList<>(cloneList);
            ArrayList<String> newAnswerList = new ArrayList<>(answerList);
            newList.remove((int) indexList.get(i));
            newAnswerList.add(arriveList.get(i));

            dfs(arriveList.get(i), newList, newAnswerList, n - 1);
        }
    }

    static class Path {
        private ArrayList<String> list;

        public Path(ArrayList<String> list) {
            this.list = list;
        }

        public ArrayList<String> getList() {
            return list;
        }
    }

    static class PathComparator implements Comparator<Path> {

        @Override
        public int compare(Path o1, Path o2) {
            for (int i = 1; i < o1.getList().size(); i++) {
                for (int j = 0; j < 3; j++) {
                    if (o1.getList().get(i).charAt(j) < o2.getList().get(i).charAt(j)) {
                        return -1;
                    } else if (o1.getList().get(i).charAt(j) > o2.getList().get(i).charAt(j)) {
                        return 1;
                    }
                }
            }
            return 0;
        }
    }
}
