import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static final int DWARF_NUM = 9;
    public static final int ORIGIN_DWARF_NUM = 7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = new int[DWARF_NUM];
        int sum = 0;
        for (int i = 0; i < DWARF_NUM; i++) {
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }

        boolean isFind = false;

        int[] output = new int[ORIGIN_DWARF_NUM];
        for (int i = 0; i < DWARF_NUM; i++) {
            for (int j = i + 1; j < DWARF_NUM; j++) {
                if ((sum - (input[i] + input[j])) == 100) {
                    int idx = 0;
                    for (int k = 0; k < DWARF_NUM; k++) {
                        if (k != i && k != j) {
                            // 0 1 2 3 4 5 6 i = 2, j = 4
                            output[idx++] = input[k];
                        }
                    }
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }
        Arrays.sort(output);

        for (int n : output) {
            bw.write(n + "");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
