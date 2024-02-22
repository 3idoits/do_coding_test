import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, Integer> nameIndexMap;
    static int nameIndexSequence;
    static int[] parents, level;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());

        while (testCase-- > 0) {
            int friendNumber = Integer.parseInt(bufferedReader.readLine());

            parents = new int[friendNumber*2];
            level = new int[friendNumber*2];
            for (int i = 0; i < friendNumber*2; i++) {
                parents[i] = i;
                level[i] = 1;
            }

            nameIndexSequence = 0;
            nameIndexMap = new HashMap<>(friendNumber*2);

            StringTokenizer tokenizer;
            for (int i = 0; i < friendNumber; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                String friendOne = tokenizer.nextToken();
                String friendTwo = tokenizer.nextToken();

                putNameIndexMap(friendOne);
                putNameIndexMap(friendTwo);

                System.out.println(union(nameIndexMap.get(friendOne), nameIndexMap.get(friendTwo)));
            }
        }
    }

    private static void putNameIndexMap(String name) {
        if (!nameIndexMap.containsKey(name)) {
            nameIndexMap.put(name, nameIndexSequence++);
        }
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
            level[x] += level[y];

            level[y] = 1;
        }
        return level[x];
    }


}
