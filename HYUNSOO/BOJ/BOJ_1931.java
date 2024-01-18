import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    private static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting that) {
            return (this.end == that.end) ? this.start - that.start : this.end - that.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Queue<Meeting> table = new PriorityQueue<>(n);

        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            table.add(new Meeting(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }

        int count = 0;
        int endTime = 0;
        while (!table.isEmpty()) {
            Meeting current = table.poll();
            if (endTime <= current.start) {
                count += 1;
                endTime = current.end;
            }
        }

        System.out.println(count);
    }
}
