package strings;

import java.io.*;

public class LongestPalindromicSubstring {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(reader.readLine());
        while (testCaseCount-- > 0) {
            String string = reader.readLine().trim();
            String palindromeStr = getLargestPalindromicString(string);
            writer.write(palindromeStr + "\n");
            writer.flush();
        }
    }


    private static String getLargestPalindromicString(String string) {

        //char[] strArr = string.toCharArray();
        int stringLength = string.length();
        int finalAns = 0;
        String finalStr = "";
        //Considering elements as center one by one and checking if it is palindrome or not using BS
        String oddAns, evenAns;
        int loopCount = stringLength - 1;

        for (int i = 0; i < loopCount; i++) {

            oddAns = BS(string, stringLength, i, i);

            finalStr = oddAns.length() > finalStr.length() ? oddAns : finalStr;
            //finalAns = Math.max(finalAns, oddAns);

            if (string.charAt(i) == string.charAt(i + 1)) {
                evenAns = BS(string, stringLength, i, i + 1);
                finalStr = evenAns.length() > finalStr.length() ? evenAns : finalStr;
                //finalAns = Math.max(finalAns, evenAns);
            }
        }
        //return finalAns;
        return finalStr;
    }

    private static String BS(String string, int stringLength, int c1, int c2) {
        int ans = 0;
        int lo = 0, hi = Math.min(c1, stringLength - c2 - 1);

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPalindromeNew(string, stringLength, c1 - mid, c2 + mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        String outStr = string.substring(c1 - ans, c1 - ans + 1 + (c2 - c1));

        return outStr;
        //return 2 * ans + 1 + (c2 - c1);
    }

    private static boolean isPalindromeNew(String string, int stringLength, int p1, int p2) {

        String subStr = string.substring(p1, p2);

        String revStr = new StringBuilder(subStr).reverse().toString();

        return (subStr.equalsIgnoreCase(revStr));
    }


    /*private static boolean isPalindrome(char[] string, int stringLength, int p1, int p2) {
        long forwardHashVal = (forwardHashArr[p2] - forwardHashArr[p1] + ((string[p1] * powerArr[p1]) % z) + z) % z;
        long backwardHashVal = (backwardHashArr[p1] - backwardHashArr[p2] + ((string[p2] * powerArr[stringLength - 1 - p2]) % z) + z) % z;

        int smallestPowerInForwardHash = p1 + 1;//Smallest power of prime in forward hash
        int smallestPowerInBackwardHash = stringLength - p2; //Smallest power of prime in backward hash
        int powerDiff = Math.abs(smallestPowerInForwardHash - smallestPowerInBackwardHash);



        if (smallestPowerInForwardHash < smallestPowerInBackwardHash) {
            forwardHashVal = (forwardHashVal * powerArr[powerDiff - 1]) % z;
        } else if (smallestPowerInForwardHash > smallestPowerInBackwardHash) {
            backwardHashVal = (backwardHashVal * powerArr[powerDiff - 1]) % z;
        }
        return (forwardHashVal == backwardHashVal);
    }*/
}