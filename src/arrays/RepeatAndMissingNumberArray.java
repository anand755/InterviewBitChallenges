package arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RepeatAndMissingNumberArray {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            List<Integer> listInput = Stream.of(reader.readLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());

            ArrayList<Integer> outPutList = repeatedNumber(listInput);
            for (int i = 0; i < outPutList.size(); i++) {
                writer.write(outPutList.get(i) + " ");
            }
            writer.write("\n");
            writer.flush();
        }

    }

    private static ArrayList<Integer> repeatedNumber(final List<Integer> listInput) {

        int length = listInput.size();
        List<Integer> naturalList = IntStream.rangeClosed(1, length).boxed().collect(Collectors.toList());
        ArrayList<Integer> outList = new ArrayList<>();

        int bothXor = 0;

        for (int i = 0; i < length; i++) {
            bothXor = bothXor ^ listInput.get(i) ^ naturalList.get(i);
        }

        int rightMostSetBit = 0;
        for (int i = 0; i < 31; i++) {
            if (isChekBit(bothXor, i)) {
                rightMostSetBit = i;
                break;
            }
        }

        int number1 = 0;
        int number2 = 0;

        for (int num : listInput) {
            if (isChekBit(num, rightMostSetBit)) {
                number1 = number1 ^ num;
            } else {
                number2 = number2 ^ num;
            }
        }

        for (int num : naturalList) {
            if (isChekBit(num, rightMostSetBit)) {
                number1 = number1 ^ num;
            } else {
                number2 = number2 ^ num;
            }
        }

        if (listInput.contains(number1)) {
            outList.add(number1);
            outList.add(number2);
        } else {
            outList.add(number2);
            outList.add(number1);
        }
        return outList;
    }

    private static boolean isChekBit(int num, int pos) {
        return (((1 << pos) & num) == (1 << pos));
    }
}
