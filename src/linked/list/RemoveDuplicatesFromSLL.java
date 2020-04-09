package linked.list;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSLL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            //int arrLength = Integer.parseInt(reader.readLine());
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            for (int num : arrInput) {
                dummy.next = new ListNode(num);
                dummy = dummy.next;
            }
            head = head.next;


            //ListNode ans = getDistinct(head);
            ListNode ans = getDistinct(head);


            while (ans != null) {
                writer.write(ans.data + " ");
                ans = ans.next;
            }
            writer.write("\n");
            writer.flush();
        }
    }

    private static ListNode getDistinct(ListNode head) {

        Set<ListNode> allSet = new HashSet<>();
        Set<ListNode> duplicateSet = new HashSet<>();

        while (head != null) {
            if (allSet.contains(head)) {
                duplicateSet.add(head);
            } else {
                allSet.add(head);
            }
            head = head.next;
        }

        allSet.removeAll(duplicateSet);

        ListNode root = new ListNode(0);
        ListNode tempRoot = root;
        for (ListNode node : allSet) {
            root.next = node;
            root = root.next;
        }
        return tempRoot.next;

    }

    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
