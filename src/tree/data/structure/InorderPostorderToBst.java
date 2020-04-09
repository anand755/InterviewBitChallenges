package tree.data.structure;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InorderPostorderToBst {
    private static int postIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            //int arrLength = Integer.parseInt(reader.readLine());

            System.out.println("Give Inorder(LDR) and then PostOrder(LRD) : ");
            ArrayList<Integer> inOrder_ldr = new ArrayList<>(Stream.of(reader.readLine().split("\\s")).map(Integer::valueOf).collect(Collectors.toList()));
            ArrayList<Integer> postOrder_lrd = new ArrayList<>(Stream.of(reader.readLine().split("\\s")).map(Integer::valueOf).collect(Collectors.toList()));
            getAns(inOrder_ldr, postOrder_lrd);
            writer.write("\n");
            writer.flush();
        }
        //writer.flush();
    }

    private static Node getAns(ArrayList<Integer> inOrder_ldr, ArrayList<Integer> postOrder_lrd) {


        int length = inOrder_ldr.size();
        postIndex = length - 1;

        Integer[] inOrderLdr = new Integer[length];
        Integer[] postOrderLrd = new Integer[length];

        inOrderLdr = inOrder_ldr.toArray(inOrderLdr);
        postOrderLrd = postOrder_lrd.toArray(postOrderLrd);

        //Node headNode = buildTree(inOrder_ldr, preOrder_dlr, 0, arrLength - 1);
        Node root = prepareBst(inOrderLdr, postOrderLrd, 0, length - 1);
        return root;

    }


    private static Node prepareBst(Integer[] inOrder, Integer[] postOrder, int inStart, int inEnd) {

        if (inStart > inEnd)
            return null;

        Node root = new Node(postOrder[postIndex--]);


        int inIndex = getIndex(inOrder, inStart, inEnd, root.data);
        root.right = prepareBst(inOrder, postOrder, inIndex + 1, inEnd);
        root.left = prepareBst(inOrder, postOrder, inStart, inIndex - 1);
        return root;
    }

    private static int getIndex(Integer[] arr, int start, int end, int value) {

        for (int i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return 0;
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        private Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
