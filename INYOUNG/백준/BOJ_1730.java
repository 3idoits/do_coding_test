import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String command = br.readLine();

        boolean[][] vertical = new boolean[n][n];
        boolean[][] horizontal = new boolean[n][n];

        int r = 0;
        int c = 0;
        for (int i = 0; i < command.length(); i++) {
            char cmd = command.charAt(i);
            if (cmd == 'D') {
                if (r == n - 1) {
                    continue;
                }
                vertical[r][c] = vertical[r + 1][c] = true;
                r++;
            } else if (cmd == 'U') {
                if (r == 0) {
                    continue;
                }
                vertical[r][c] = vertical[r - 1][c] = true;
                r--;
            } else if (cmd == 'L') {
                if (c == 0) {
                    continue;
                }
                horizontal[r][c] = horizontal[r][c - 1] = true;
                c--;
            } else {
                if (c == n - 1) {
                    continue;
                }
                horizontal[r][c] = horizontal[r][c + 1] = true;
                c++;
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (horizontal[i][j] && vertical[i][j]) {
                    ans.append("+");
                } else if (vertical[i][j]) {
                    ans.append("|");
                } else if (horizontal[i][j]) {
                    ans.append("-");
                } else {
                    ans.append(".");
                }
            }
            System.out.println(ans);
        }
    }
}
