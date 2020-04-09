package arrays;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LargestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            List<Integer> listInput = Stream.of(reader.readLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());

            String number = largestNumber(listInput);
            writer.write(number + "\n");
            writer.flush();
        }
    }

    private static String largestNumber(List<Integer> listInput) {
        int zeroCount = 0;
        for (int i = 0; i < listInput.size(); i++) {
            if (listInput.get(i) == 0) {
                zeroCount++;
            } else {
                break;
            }
        }
        if (zeroCount == listInput.size()) {
            return "0";
        }
        listInput.sort((a, b) -> (b + "" + a).compareTo(a + "" + b));
        StringBuilder builder = new StringBuilder();
        listInput.forEach(builder::append);
        return Integer.valueOf(builder.toString()).toString();
    }
}
