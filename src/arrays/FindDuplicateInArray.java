package arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindDuplicateInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            List<Integer> listInput = Stream.of(reader.readLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());

            int number = repeatedNumber(listInput);
            writer.write(number + "\n");
            writer.flush();
        }
    }

    private static int repeatedNumber(final List<Integer> listInput) {

        int result = 0;


        List<Integer> naturalList = IntStream.rangeClosed(1, listInput.size() + 1).boxed().collect(Collectors.toList());

        for (int num : naturalList) {
            result = result ^ num;
        }

        for (int num : listInput) {
            result = result ^ num;
        }


        return result;
    }
}
