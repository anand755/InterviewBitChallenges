package arrays;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NBy3RepeatNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] inputArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            int sqrtNumber = getNBy3RepeatNumber(inputArr);

            writer.write(sqrtNumber + "\n");
            writer.flush();
        }
        writer.flush();

    }

    private static int getNBy3RepeatNumber(int[] inputArr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : inputArr) {
            if (map.getOrDefault(num, 0) + 1 > inputArr.length / 3) {
                return num;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return -1;
    }
}
