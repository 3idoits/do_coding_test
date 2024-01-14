import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);

            int floor = ((n - 1) % h) + 1;
            int number = (n - 1) / h + 1;
            System.out.printf("%d%02d\n", floor, number);
        }
    }
}
