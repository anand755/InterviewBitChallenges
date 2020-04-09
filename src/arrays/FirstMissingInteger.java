package arrays;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstMissingInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            List<Integer> inputList = Stream.of(reader.readLine().split("\\s")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());

            int missingNumber = getFirstMissingNumber(inputList);
            writer.write(missingNumber + "\n");
            writer.flush();
        }
        writer.flush();
    }

    private static int getFirstMissingNumber(List<Integer> listInput) {
        boolean[] positiveArr = new boolean[listInput.size() + 1];

        Arrays.fill(positiveArr, false);

        for (int num : listInput) {
            if (num > 0 && num <= listInput.size()) {
                positiveArr[num] = true;
            }
        }

        int j = 1;

        for (; j < positiveArr.length; j++) {
            if (!positiveArr[j]) {
                return j;
            }
        }

        return j;
    }
}
