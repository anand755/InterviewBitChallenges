package stack.and.queues;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LargestRectangleInHistogram {
    //This is more optimized code . Having Single for loop .. O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int buildingsCount = Integer.parseInt(reader.readLine());
            //int[] buildingsHeight = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> inputList = (ArrayList<Integer>) Stream.of(reader.readLine().split("\\s")).map(Integer::valueOf).collect(Collectors.toList());


            int largestArea = largestRectangleArea(inputList);
            writer.write(largestArea + "\n");
            //writer.flush();
        }
        writer.flush();
    }

    private static int largestRectangleArea(ArrayList<Integer> inputList) {
        int area = 0;

        int length = inputList.size();
        int[] nextSmallerElementIndexArr = new int[length];
        int[] prevSmallerElementIndexArr = new int[length];


        Stack<Integer> stackForNext = new Stack<>();
        Stack<Integer> stackForPrev = new Stack<>();

        for (int i = 0; i < length; i++) {

            //Computing Next Smaller Element Index
            if (stackForNext.isEmpty()) {
                stackForNext.push(i);
            } else {
                while ((!stackForNext.isEmpty()) && (inputList.get(stackForNext.peek()) > inputList.get(i))) {
                    nextSmallerElementIndexArr[stackForNext.pop()] = i;
                }
                stackForNext.push(i);
            }


            //Computing Previous Smaller Element Index
            int j = (length - 1) - i;
            if (stackForPrev.isEmpty()) {
                stackForPrev.push(j);
            } else {
                while ((!stackForPrev.isEmpty()) && (inputList.get(j) < inputList.get(stackForPrev.peek()))) {
                    prevSmallerElementIndexArr[stackForPrev.pop()] = j;
                }
                stackForPrev.push(j);
            }

        }
        while (!stackForNext.isEmpty()) {
            nextSmallerElementIndexArr[stackForNext.pop()] = length;
        }

        while (!stackForPrev.isEmpty()) {
            prevSmallerElementIndexArr[stackForPrev.pop()] = -1;
        }





        for (int i = 0; i < length; i++) {
            int width = (nextSmallerElementIndexArr[i] - prevSmallerElementIndexArr[i] - 1);
            int currArea = width * inputList.get(i);
            area = Math.max(area, currArea);
        }

        return area;
    }
}
