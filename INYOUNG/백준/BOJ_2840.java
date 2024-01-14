import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        char[] ans = new char[n];
        Arrays.fill(ans, '?');

        int curIdx = 0;
        while (k-- > 0) {
            String[] step = br.readLine().split(" ");
            int backStep = Integer.parseInt(step[0]);
            char backAlp = step[1].charAt(0);

            int nextIdx = ((curIdx - backStep) % n + n) % n;
            if (ans[nextIdx] == '?') {
                ans[nextIdx] = backAlp;
            } else if (ans[nextIdx] != backAlp) {
                System.out.println("!");
                return;
            }
            curIdx = nextIdx;
        }

        boolean[] chk = new boolean[26];
        for (int i = 0; i < n; i++) {
            if (ans[i] == '?') {
                continue;
            }
            if (chk[ans[i] - 'A']) {
                System.out.println("!");
                return;
            }
            chk[ans[i] - 'A'] = true;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[(curIdx + i) % n]);
        }
        System.out.println();
    }
}
