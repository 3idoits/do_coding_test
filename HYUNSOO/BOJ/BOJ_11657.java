import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int cityNum, roadNum, INF = 60_000_000;
    static List<Node>[] map;
    static long[] minDistance;

    private static class Node {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        cityNum = Integer.parseInt(tokenizer.nextToken());
        roadNum = Integer.parseInt(tokenizer.nextToken());

        minDistance = new long[cityNum+1];
        Arrays.fill(minDistance, INF);

        map = new List[cityNum+1];
        for (int i = 0; i < cityNum + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < roadNum; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            map[start].add(new Node(end, weight));
        }

        calcMinDistanceFromFirstCity();
        if (isCreatedNegativeCycle()) {
            System.out.println(-1);
            return;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 2; i < cityNum + 1; i++) {
            if (minDistance[i] == INF) {
                answer.append(-1).append("\n");
                continue;
            }
            answer.append(minDistance[i]).append("\n");
        }
        System.out.println(answer);
    }

    private static void calcMinDistanceFromFirstCity() {
        minDistance[1] = 0;
        
        // node 수 - 1번 반복
        for (int repeat = 1; repeat < cityNum; repeat++) {

            for (int current = 1; current < cityNum + 1; current++) {
                for (Node next : map[current]) {
                    if (minDistance[current] == INF)
                        break;

                    long nextWeight = minDistance[current] + next.weight;
                    if (nextWeight < minDistance[next.end]) {
                        minDistance[next.end] = nextWeight;
                    }
                }
            }
        }
    }

    private static boolean isCreatedNegativeCycle() {
        for (int current = 1; current < cityNum + 1; current++) {
            for (Node next : map[current]) {
                if (minDistance[current] == INF)
                    break;

                long nextWeight = minDistance[current] + next.weight;
                if (nextWeight < minDistance[next.end]) {
                    return true;
                }
            }
        }
        return false;
    }
}
