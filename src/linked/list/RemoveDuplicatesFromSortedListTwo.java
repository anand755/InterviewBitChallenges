package linked.list;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class RemoveDuplicatesFromSortedListTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            //int arrLength = Integer.parseInt(reader.readLine());
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            ListNode dummy = new ListNode(null);
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
        ListNode dummy = new ListNode(null);
        ListNode tHead = dummy;

        if (head == null) {
            return null;
        }

        while (head != null) {
            Integer removeVal = null;

            if (head.next != null && head.data.equals(head.next.data)) {
                removeVal = head.data;
            } else {
                dummy.next = head;
                dummy = dummy.next;
                head = head.next;
                dummy.next = null;
            }
            while (head != null && head.data.equals(removeVal)) {
                head = head.next;
            }
        }
        return tHead.next;
    }

    private static class ListNode {
        Integer data;
        ListNode next;

        ListNode(Integer data) {
            this.data = data;
            this.next = null;
        }
    }
}
