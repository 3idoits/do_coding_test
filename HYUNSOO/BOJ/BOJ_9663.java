import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int n, answer;
    static int[] queens; // index는 Y축, index의 value는 X축

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        queens = new int[n];
        calcQueensCount(0);
        System.out.println(answer);
    }

    private static void calcQueensCount(int depth) {
        if (depth == n) {
            answer += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            queens[depth] = i;
            if (isAvailablePosition(i, depth)) {
                calcQueensCount(depth + 1);
            }
        }
    }

    private static boolean isAvailablePosition(int x, int y) {
        for (int queenY = 0; queenY < y; queenY++) {
            int queenX = queens[queenY];

            if (x == queenX) return false;
            if (Math.abs(queenX - x) == Math.abs(queenY - y)) return false;
        }
        return true;
    }
}
