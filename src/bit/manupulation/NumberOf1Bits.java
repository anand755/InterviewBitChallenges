package bit.manupulation;

import java.io.*;

public class NumberOf1Bits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        //while (testCaseCount-- > 0) {
        long inputNum = Long.parseLong(reader.readLine());
        int ans = getSetBitCount(inputNum);
        writer.write(ans + "\n");
        writer.flush();
        //}
        //writer.flush();
    }

    private static int getSetBitCount(long inputNum) {
        int count = 0;
        for (int i = 0; i <= 31; i++) {
            if (CB(inputNum, i))
                count++;
        }
        return count;
    }

    private static boolean CB(long num, int pos) {
        return (((1L << pos) & num) == (1L << pos));
    }
}
