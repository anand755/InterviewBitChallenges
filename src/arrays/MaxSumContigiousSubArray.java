package arrays;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxSumContigiousSubArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        Set<String> treeSet;

        while (testCaseCount-- > 0) {
            int inputLength = Integer.parseInt(reader.readLine());
            List<String> list = Stream.of(reader.readLine().split("\\s")).collect(Collectors.toList());
            int ans = maxSubArray(list);
            writer.write(ans + "\n");
            writer.flush();
        }
    }

    private static int maxSubArray(final List<String> list) {


        Set<String> treeSet = new TreeSet<>();

        int[] arrayInput = treeSet.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(arrayInput);

        int maxCount = 1;
        int length = arrayInput.length;
        for (int i = 0; i < length; i++) {
            int currCount = 1;
            for (int j = i; j < length; j++) {

                if ((j - i) == (arrayInput[j] - arrayInput[i])) {
                    currCount = j - i + 1;
                    maxCount = Math.max(maxCount, currCount);
                } else {
                    break;
                }
            }
        }
        return maxCount;
    }
}
