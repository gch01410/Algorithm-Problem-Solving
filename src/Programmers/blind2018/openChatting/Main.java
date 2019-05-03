package Programmers.blind2018.openChatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }

    private static String[] solution(String[] record) {
        ArrayList<String> prototype = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] records = record[i].split(" ");
            String command = records[0];
            String uid = records[1];
            if (command.equals("Enter")) {
                String nickName = records[2];
                map.put(uid, nickName);
                prototype.add(command + " " + uid);
            } else if (command.equals("Leave")) {
                prototype.add(command + " " + uid);
            } else if (command.equals("Change")) {
                String nickName = records[2];
                map.put(uid, nickName);
            }
        }

        String[] answer = new String[prototype.size()];

        for (int i = 0; i < prototype.size(); i++) {
            String command = prototype.get(i).split(" ")[0];
            String uid = prototype.get(i).split(" ")[1];
            if (command.equals("Enter")) {
                answer[i] = map.get(uid) + "님이 들어왔습니다.";
            } else if (command.equals("Leave")) {
                answer[i] = map.get(uid) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
