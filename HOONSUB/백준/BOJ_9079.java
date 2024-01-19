import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[][] CONVERT_LINE = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // ROW
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // COL
            {0, 4, 8}, {2, 4, 6} // 대각선
    };
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answerBuilder = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());

        for (int test = 0; test < T; test++) {
            // 2차원 배열을 1차원 배열로 표현
            int offset = 0;
            char[] map = new char[9];
            for (int i = 0; i < 3; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int idx = 0; idx < 3; idx++) {
                    map[idx + offset] = tokenizer.nextToken().charAt(0);
                }
                offset += 3;
            }

            // 탐색 시작 및 정답을 도출
            int result = search(map);
            answerBuilder.append(result).append("\n");
        }
        System.out.println(answerBuilder);
    }

    /**
     * BFS 탐색을 실행하는 메서드
     */
    private static int search(char[] map) {
        Map<String, Boolean> visited = new HashMap<>();
        Queue<SearchElement> queue = new LinkedList<>();
        queue.add(new SearchElement(map, 0));
        visited.put(String.valueOf(map), true);

        while (!queue.isEmpty()) {
            SearchElement element = queue.poll();

            if (isMatch(element.map)) {
                return element.sum;
            }

            for (int[] line : CONVERT_LINE) {
                char[] copyMap = element.getCopiedArray();
                copyMap[line[0]] = convert(copyMap[line[0]]);
                copyMap[line[1]] = convert(copyMap[line[1]]);
                copyMap[line[2]] = convert(copyMap[line[2]]);
                String visitedKey = String.valueOf(copyMap);
                if (!visited.containsKey(visitedKey)) {
                    visited.put(visitedKey, true);
                    queue.add(new SearchElement(copyMap, element.sum + 1));
                }
            }
        }

        return -1;
    }

    /**
     * H는 T로 T는 H로 변환하는 메서드
     */
    private static char convert(char ch) {
        return ch == 'H' ? 'T' : 'H';
    }

    /**
     * 모든 값이 H 또는 T로 일치하는지 확인하는 메서드
     */
    private static boolean isMatch(char[] map) {
        char target = map[0];
        for (char ch : map) {
            if (ch != target) return false;
        }
        return true;
    }
}

/**
 * 탐색에 사용하기 위한 Wrapper 객체
 */
class SearchElement {
    char[] map;
    int sum;

    public SearchElement(char[] map, int sum) {
        this.map = map;
        this.sum = sum;
    }

    public char[] getCopiedArray() {
        char[] result = new char[map.length];
        for (int i = 0; i < map.length; i++) result[i] = map[i];

        return result;
    }
}
