package arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountingTriangles {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int noOfRods = Integer.parseInt(reader.readLine());
            int[] rodsArr = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            //int noOfTriangles = getNoOfTriangles(rodsArr, noOfRods);
            //writer.write(noOfTriangles + "\n");
            //writer.flush();
        }
        writer.flush();
    }

    private static int getNoOfTriangles(ArrayList<Integer> rodsArr) {
        Collections.sort(rodsArr);
        //Arrays.sort(rodsArr);

        int M = (int)1e9+7;
        int triangleCount = 0;
        int i = 0;
        int j = 1;
        while (i < rodsArr.size() - 2) {
            int k = j + 1;
            while ((k < rodsArr.size()) && (rodsArr.get(i) + rodsArr.get(j) > rodsArr.get(k))) {
                k++;
            }
            triangleCount = (triangleCount + (k - j - 1))%M;
            j++;
            if (j == rodsArr.size()) {
                i++;
                j = i + 1;
            }
        }

        return triangleCount;
    }
}
