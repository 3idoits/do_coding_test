import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] arrival = br.readLine().split(" ");
        int time = Integer.parseInt(br.readLine());

        int currentW = Integer.parseInt(arrival[0]);
        int currentH = Integer.parseInt(arrival[1]);
        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);

        int p = (currentW + time) % (w * 2);
        int q = (currentH + time) % (h * 2);
        if (p > w) {
            p = w - (p - w);
        }

        if (q > h) {
            q = h - (q - h);
        }

        System.out.printf("%d %d", p, q);
    }
}
