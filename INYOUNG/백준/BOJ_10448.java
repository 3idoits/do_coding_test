import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] isEurekaNumber = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        preprocess();
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(isEurekaNumber[num]? 1 : 0);
        }
    }

    public static void preprocess() {
        int[] eureka = new int[45];
        int count = 0;
        for (int i = 1; i <= 45; i++) {
            int num = i * (i + 1) / 2;
            eureka[count++] = num;
        }

        boolean[] isSumOfTriangle = new boolean[1000];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                int sum = eureka[i] + eureka[j];
                if (sum < 1000) {
                    isSumOfTriangle[sum] = true;
                }
            }
        }

        for (int i = 1; i < 1000; i++) {
            if (isSumOfTriangle[i]) {
                for (int j = 0; j < count; j++) {
                    int sum = eureka[j] + i;
                    if (sum <= 1000) {
                        isEurekaNumber[sum] = true;
                    }
                }
            }
        }
    }
}
