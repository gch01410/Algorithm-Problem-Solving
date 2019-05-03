package Programmers.blind2018.candidateKey;

import java.util.HashSet;

public class Main {
    private static HashSet<Integer> keys = new HashSet<>();
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }

    private static int solution(String[][] relation) {
        dfs(0, relation, 0);
        dfs(0, relation, 1);

        return keys.size();
    }

    private static void dfs(int n, String[][] relation, int bit) {
        if (n == relation[0].length) {
            return;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < relation[0].length; j++) {
                if ((bit & (1 << j)) == 1<<j) {
                    str.append(relation[i][j]);
                }
            }
            set.add(str.toString());
        }

        if (set.size() == relation.length) {
            boolean stat = false;
            for (int key : keys) {
                if ((bit & key) == bit || (bit & key) == key){
                    stat = true;
                    break;
                }
            }
            if (!stat) {
                keys.add(bit);
            }
        }

        dfs(n + 1, relation, bit);
        dfs(n + 1, relation, bit | (1 << n + 1));
    }
}
