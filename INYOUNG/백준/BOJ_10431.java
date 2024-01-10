import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final int NUM = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int[] line = new int[NUM];

            for (int i = 0; i < NUM; i++) {
                line[i] = Integer.parseInt(input[i + 1]);
            }

            int count = 0;
            int[] sorted = new int[NUM];
            for (int i = 0; i < NUM; i++) {
                boolean isFind = false;
                for (int j = 0; j < i; j++) {
                    if (sorted[j] > line[i]) {
                        isFind = true;
                        for (int k = i - 1; k >= j; k--) {
                            sorted[k + 1] = sorted[k];
                            count++;
                        }
                        sorted[j] = line[i];
                        break;
                    }
                }

                if (!isFind) {
                    sorted[i] = line[i];
                }
            }
            System.out.println(p + " " + count);
        }
    }
}
