package Programmers.stackQueue.no1;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("()(((()())(())()))(())"));
    }

    private static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < arrangement.length(); i++) {
            char token = arrangement.charAt(i);
            if (token == '(') {
                stack.push(token);
                count++;
                answer++;
            } else if (token == ')') {
                if (stack.peek() == '(') {
                    count--;
                    answer--;
                    answer += count;
                } else if (stack.peek() == ')') {
                    count--;
                }
                stack.push(token);
            }
        }

        return answer;
    }
}
