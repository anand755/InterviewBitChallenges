package bit.manupulation;

import java.io.*;
import java.util.Stack;

public class ChangingDirectories {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            Stack<String> directoryStack = new Stack<>();

            String commandStr = reader.readLine().trim();
            String result = executeCommand(commandStr);

            writer.write(result);
            writer.flush();
        }
        //writer.flush();
    }

    private static String executeCommand(String commandStr) {
        Stack<String> directoryStack = new Stack<>();

        String pwdString = "/";
        String[] dirs = commandStr.split("/");
        directoryStack.clear();
        //directoryStack.empty();
        for (String dir : dirs) {
            if (dir.equals("..") || dir.equals(".")) {
                if (!directoryStack.isEmpty())
                    directoryStack.pop();
            } else
                directoryStack.push(dir);
        }


        if (!directoryStack.isEmpty()) {

            pwdString = "";
            for (String dir : directoryStack) {

                pwdString = "/" + pwdString + dir;
            }
        }

        return pwdString;

    }
}
