import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String ans = "";
        while (num > 0) {
            int digit = num % k;
            if (digit < 10) {
                ans += digit;
            } else {
                ans += (char)(digit - 10 + 'A');
            }
            num /= k;
        }

        for (int i = ans.length() - 1; i >= 0; i--) {
            System.out.print(ans.charAt(i));
        }
    }
}
