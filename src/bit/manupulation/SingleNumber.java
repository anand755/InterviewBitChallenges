package bit.manupulation;

import java.io.*;
import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        writer.write(res+"");
        writer.flush();
    }
}
