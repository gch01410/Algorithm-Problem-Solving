package Programmers.teepsdown2017.no1;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    private static int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (stack.empty()){
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.empty()) {
            answer = 1;
        }
        return answer;
    }
}
