package arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestConcatNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        for (int j = 0; j < noOfTestCases; j++) {
            int arrLen = scanner.nextInt();
            Integer arr[] = new Integer[arrLen];
            for (int i = 0; i < arrLen; i++) {
                arr[i] = scanner.nextInt();
            }
            sortLargestConcat(arr, arrLen);
            System.out.print("\n");
        }

    }


    static void sortLargestConcat(Integer[] arr, int n) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (Integer.parseInt(o1 + "" + o2) - Integer.parseInt(o2 + "" + o1));
            }
        };


        Arrays.sort(arr, comparator);

        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + "");
        }
    }

}
