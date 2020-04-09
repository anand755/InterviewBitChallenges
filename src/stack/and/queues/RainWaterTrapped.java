package stack.and.queues;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RainWaterTrapped {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            List<Integer> listInput = Stream.of(reader.readLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());

            int ans = getTrap(listInput);


            writer.write(ans + "\n");

            writer.flush();
        }
    }

    private static int getTrap(List<Integer> listInput) {

        int buildingCount = listInput.size();
        if (buildingCount <= 2) {
            return 0;
        }

        int[] leftMax = new int[buildingCount - 2];
        int[] rightMax = new int[buildingCount - 2];

        int leftSideMax = listInput.get(0);
        for (int i = 1; i < (buildingCount - 1); i++) {
            leftSideMax = Math.max(listInput.get(i - 1), leftSideMax);
            leftMax[i - 1] = leftSideMax;
        }

        int rightSideMax = listInput.get(buildingCount - 1);
        for (int i = (buildingCount - 2); i >= 1; i--) {
            rightSideMax = Math.max(listInput.get(i + 1), rightSideMax);
            rightMax[i - 1] = rightSideMax;
        }

        int totalStoreWater = 0;
        for (int i = 1; i <= (buildingCount - 2); i++) {
            int commonWaterLevel = Math.min(leftMax[i - 1], rightMax[i - 1]);
            int storedWater = commonWaterLevel > listInput.get(i) ? (commonWaterLevel - listInput.get(i)) : 0;
            totalStoreWater += storedWater;
        }

        return totalStoreWater;
    }
}
