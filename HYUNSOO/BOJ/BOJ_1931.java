import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Queue<Time> queue = new PriorityQueue<>();

        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            queue.add(new Time(start, end));
        }

        int current = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            Time cur = queue.poll();
            if (cur.start >= current) {
                current = cur.end;
                count += 1;
            }
        }
        System.out.println(count);
    }

    private static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time that) {
            if (this.end == that.end) {
                return this.start - that.start;
            }
            return this.end - that.end;
        }
    }
}
