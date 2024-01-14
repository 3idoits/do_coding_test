import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    swapCandy(map, i, j, i, j + 1);
                    ans = Math.max(ans, calcScore(map));
                    swapCandy(map, i, j, i, j + 1);
                }

                if (i + 1 < n) {
                    swapCandy(map, i, j, i + 1, j);
                    ans = Math.max(ans, calcScore(map));
                    swapCandy(map, i, j, i + 1, j);
                }
            }
        }
        System.out.println(ans);
    }

    private static int calcScore(char[][] map) {
        int n = map.length;
        int maxScore = 0;
        for (char[] chars : map) {
            int score = 1;
            for (int j = 1; j < n; j++) {
                if (chars[j] == chars[j - 1]) {
                    score++;
                } else {
                    maxScore = Math.max(maxScore, score);
                    score = 1;
                }
            }
            maxScore = Math.max(maxScore, score);
        }

        for (int i = 0; i < n; i++) {
            int score = 1;
            for (int j = 1; j < n; j++) {
                if (map[j][i] == map[j - 1][i]) {
                    score++;
                } else {
                    maxScore = Math.max(maxScore, score);
                    score = 1;
                }
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    private static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
        char tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }
}
