import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n, c;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());
        houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(houses);

        int min = 1;
        int max = houses[n-1];
        int length = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            
            if (calcCount(mid) < c) {
                max = mid - 1;
            } else {
                length = Math.max(length, mid);
                min = mid + 1;
            }
        }
        System.out.println(length);
    }

    private static int calcCount(int mid) {
        int count = 1;
        int lastPosition = houses[0];
        for (int i = 1; i < n; i++) {
            if (houses[i] - lastPosition >= mid) {
                count += 1;
                lastPosition = houses[i];
            }
        }
        return count;
    }
}
