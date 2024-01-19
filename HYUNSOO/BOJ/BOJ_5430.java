import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ArrayDeque<String> deque;
        StringTokenizer tokenizer;

        int loof = Integer.parseInt(bufferedReader.readLine());

        while (loof-- > 0) {

            char[] commands = bufferedReader.readLine().toCharArray();
            int n = Integer.parseInt(bufferedReader.readLine());
            tokenizer = new StringTokenizer(bufferedReader.readLine(), "[],");

            deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.add(tokenizer.nextToken());
            }
            AC(deque, commands);
        }
        System.out.println(answer);
    }

    private static void AC(ArrayDeque<String> deque, char[] commands) {
        boolean isReverse = false;
        for (char command : commands) {
            if (command == 'R') {
                isReverse = !isReverse;
                continue;
            }
            if (deque.isEmpty()) {
                answer.append("error\n");
                return;
            }

            if (isReverse) deque.removeLast();
            else deque.removeFirst();
        }
        makePrintString(deque, isReverse);
    }

    public static void makePrintString(ArrayDeque<String> deque, boolean isReverse) {
        answer.append("[");
        if (!deque.isEmpty()) {
            if (isReverse) {
                StringBuilder temp = new StringBuilder();
                temp.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    temp.append(',').append(deque.pollLast());
                }
                answer.append(temp);
            } else answer.append(String.join(",", deque));
        }
        answer.append("]\n");
    }
}
