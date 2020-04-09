package dynamic.programming;

import java.io.*;

public class Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            int ans = getStairsWayCount(N);
            writer.write(ans + "\n");
            writer.flush();
        }
    }

    private static int getStairsWayCount(int N) {
        int[] dpTable = new int[N + 1];


        dpTable[0] = 1;
        dpTable[1] = 1;

        for (int i = 2; i <= N; i++) {
            dpTable[i] = dpTable[i - 2] + dpTable[i - 1];
        }


        return dpTable[N];
    }
}
