package linked.list;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.NodeChangeEvent;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            int arrLength = Integer.parseInt(reader.readLine());
            int[] arrInput = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            ListNode dummy = new ListNode(null);
            ListNode head = dummy;
            for (int num : arrInput) {
                dummy.next = new ListNode(num);
                dummy = dummy.next;
            }
            head = head.next;
            ListNode ans = removeDuplicates(head);
            while (ans != null) {
                writer.write(ans.data + " ");
                ans = ans.next;
            }
            writer.write("\n");
            writer.flush();
        }
    }

    private static ListNode removeDuplicates(ListNode head) {

        ListNode tHead;
        if (head.next == null) {
            return head;
        } else {
            tHead = head;
        }
        while (head.next != null) {
            if (head.data == head.next.data) {
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }

        return tHead;
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
