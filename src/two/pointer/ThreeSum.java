package two.pointer;

import java.io.*;
import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int sumInput = Integer.parseInt(reader.readLine());
            int closestSum = getClosestSum(arrInput, sumInput);
            writer.write(closestSum + "\n");
            writer.flush();
        }
    }

    private static int getClosestSum(int[] arrInput, int sumInput) {

        int length = arrInput.length;


        for (int i = 1; i <= length - 2; i++) {

        }


        return 0;


    }
}
