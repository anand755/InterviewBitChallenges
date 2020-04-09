package arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddOneToNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            List<Integer> listInput = Stream.of(reader.readLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());

            ArrayList<Integer> outPutList = plusOne(listInput);
            for (int i = 0; i < outPutList.size(); i++) {
                writer.write(outPutList.get(i) + " ");
            }
            writer.write("\n");
            writer.flush();
        }

    }

    private static ArrayList<Integer> plusOne(List<Integer> inputList) {

        //int arrLength = A.size();
        ArrayList<Integer> outList = new ArrayList<>();
        int carry = 1;

        for (int i = inputList.size() - 1; i >= 0; i--) {
            int sum = (inputList.get(i) + carry) % 10;
            carry = (inputList.get(i) + carry) / 10;
            outList.add(sum);
            //outArr[i + 1] = sum;
        }

        if (carry != 0) {
            outList.add(carry);
        } else {
            int lastIndex = outList.size() - 1;
            while (outList.get(lastIndex) == 0) {
                outList.remove(lastIndex--);
            }
        }
        Collections.reverse(outList);
        return outList;
    }
}
