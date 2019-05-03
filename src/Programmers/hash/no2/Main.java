package Programmers.hash.no2;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        solution(new String[]{"12232332","12","222222"});
        solution(new String[]{"119","97674223","1195524421"});
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

//        Arrays.sort(phone_book);

//        for (int i = 0; i<phone_book.length-2;i++){
//            if (phone_book[i].length() <= phone_book[i+1].length()){
//                if (phone_book[i+1].substring(0,phone_book[i].length()).equals(phone_book[i])){
//                    return false;
//                }
//            }
//        }

//        for (String str : phone_book){
//            System.out.println(str);
//        }

        HashSet<String> set = new HashSet<>();
        set.add(phone_book[0]);
        for(int i=1;i<phone_book.length;i++) {
            String str = phone_book[i];
            for(String setStr : set){
                if(str.length() >= setStr.length()){
                    if(str.startsWith(setStr)){
                        return false;
                    }
                } else {
                    if(setStr.startsWith(str)){
                        return false;
                    }
                }
                set.add(phone_book[i]);
            }
        }


        return answer;
    }

}
