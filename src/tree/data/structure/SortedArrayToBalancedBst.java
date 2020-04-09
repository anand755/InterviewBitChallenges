package tree.data.structure;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedArrayToBalancedBst {
    private static int postIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            //int arrLength = Integer.parseInt(reader.readLine());

            System.out.println("Give Inorder(LDR) and then PostOrder(LRD) : ");
            ArrayList<Integer> list = new ArrayList<>(Stream.of(reader.readLine().split("\\s")).map(Integer::valueOf).collect(Collectors.toList()));
            //ArrayList<Integer> postOrder_lrd = new ArrayList<>(Stream.of(reader.readLine().split("\\s")).map(Integer::valueOf).collect(Collectors.toList()));
            TreeNode root = sortedArrayToBST(list);
            writer.write("\n");
            writer.flush();
        }
        //writer.flush();
    }

    private static TreeNode getAns(ArrayList<Integer> inOrder_ldr, ArrayList<Integer> postOrder_lrd) {


        int length = inOrder_ldr.size();
        postIndex = length - 1;

        Integer[] inOrderLdr = new Integer[length];
        Integer[] postOrderLrd = new Integer[length];

        inOrderLdr = inOrder_ldr.toArray(inOrderLdr);
        postOrderLrd = postOrder_lrd.toArray(postOrderLrd);

        //TreeNode headNode = buildTree(inOrder_ldr, preOrder_dlr, 0, arrLength - 1);
        //TreeNode root = prepareBst(inOrderLdr, postOrderLrd, 0, length - 1);
        return null;

    }


    private static TreeNode sortedArrayToBST(ArrayList<Integer> list) {

        TreeNode root = new TreeNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            insertIntoTree(root, list.get(i));
        }

        return root;
    }

    private static TreeNode insertIntoTree(TreeNode root, Integer value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value > root.val) {
            root.right = insertIntoTree(root.right, value);
        } else {
            root.left = insertIntoTree(root.left, value);
        }
        return root;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        private TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}
