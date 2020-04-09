package arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Flip {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {

            String inputStr = reader.readLine();

            List<Integer> outList = flip(inputStr);
            outList.forEach(__ -> System.out.print(__ + " "));
            System.out.println();
        }
    }

    private static List<Integer> flip(String inputStr) {
        char[] inputArr = inputStr.toCharArray();

        int start = 0, end = 0;

        int gap = 0;
        int p = 0, q = 0;
        while (p < inputArr.length && q < inputArr.length) {
            if (inputArr[p] == '0') {
                start = p;

                if (inputArr[q] == '0') {
                    //end = q;
                    if (q - p > end - start) {
                        end = q;
                        start = p;
                    }
                    q++;
                    //update ans
                }else {
                    p++;
                }
                q++;


            } else {
                p++;
            }


        }
        List<Integer> outList = new ArrayList<>();
        outList.add(start);
        outList.add(end);


        return outList;
    }
}
