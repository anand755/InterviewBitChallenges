package arrays;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinXorValue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            List<Integer> listInput = Stream.of(reader.readLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());

            int number = getMinXorValue(listInput);
            writer.write(number + "\n");
            writer.flush();
        }
    }

    private static int getMinXorValue(List<Integer> listInput) {



        return 0;
    }


}
