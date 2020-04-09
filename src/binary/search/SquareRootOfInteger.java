package binary.search;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquareRootOfInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int number = Integer.parseInt(reader.readLine());

            int sqrtNumber = getSquartRoot(number);
            writer.write(sqrtNumber + "\n");
            writer.flush();
        }
        writer.flush();

    }

    private static int getSquartRoot(int number) {

        long lo = 0L, hi = number;
        long mid = 0;

        if (number == 1) {
            return 1;
        }

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (mid * mid == number) {
                return (int) mid;
            }
            if (mid * mid > number) {
                hi = mid;
            }
            if (mid * mid < number) {
                lo = mid;
            }
            if (mid * mid < number && (mid + 1) * (mid + 1) > number) {
                return (int) mid;
            }
        }

        return (int) mid;
    }
}
