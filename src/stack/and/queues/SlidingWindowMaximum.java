package stack.and.queues;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SlidingWindowMaximum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {

            //int[] NK = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            //int arrLength = NK[0];
            int windowSize = Integer.parseInt(reader.readLine());
            //int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            List<Integer> listInput = Stream.of(reader.readLine().split("\\s")).map(Integer::valueOf).collect(Collectors.toList());

            List<Integer> windowMaxList = getSumOfAllWindow(listInput, windowSize);
            for (int num : windowMaxList) {
                writer.write(num + " ");
            }
            //writer.write(totalSum + "\n");
            writer.flush();
        }
        //writer.flush();
    }

    private static List<Integer> getSumOfAllWindow(final List<Integer> listInput, int windowSize) {

        List<Integer> outList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < windowSize; i++) {

            while ((!deque.isEmpty()) && (listInput.get(deque.peekLast()) < listInput.get(i))) {
                deque.pollLast();
            }
            deque.addLast(i);

        }

        outList.add(listInput.get(deque.peekFirst()));

        for (int i = windowSize; i < listInput.size(); i++) {
            while ((!deque.isEmpty()) && (listInput.get(deque.peekLast()) < listInput.get(i))) {
                deque.pollLast();
            }
            deque.addLast(i);

            while (deque.peekFirst() <= (i - windowSize)) {
                deque.pollFirst();
            }
            outList.add(listInput.get(deque.peekFirst()));
        }
        return outList;
    }
}
