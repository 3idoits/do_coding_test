import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int n;
    static int[] board;
    static int count;

    static void DFS(int depth) {
        if (depth == n) {
            count += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[depth] = i;
            if (isPlayQueen(depth, i)) {
                DFS(depth + 1);
            }
        }
    }

    static boolean isPlayQueen(int x, int y) {
        for (int qx = 0; qx < x; qx++) {
            int qy = board[qx];

            if (qy == y) return false;
            if (Math.abs(qx - x) == Math.abs(qy - y)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        board = new int[n];
        DFS(0);
        System.out.println(count);
    }
}
