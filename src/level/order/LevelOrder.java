package level.order;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;

public class LevelOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            ArrayList<ArrayList<Integer>> levelList = levelOrder(root);
            for (ArrayList<Integer> list : levelList) {
                list.forEach(__ -> System.out.print(__ + " "));
                System.out.println();
            }

        }
    }

    private static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> levelList = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        ArrayList<Integer> currLevel = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode poppedNode = queue.poll();
            if (poppedNode == null) {
                levelList.add(new ArrayList<>(currLevel));
                currLevel.clear();
                if (queue.size() > 0) {
                    queue.add(null);
                }
            } else {
                currLevel.add(poppedNode.val);
                if (poppedNode.left != null) {
                    queue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    queue.add(poppedNode.right);
                }
            }
        }
        return levelList;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        private TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
