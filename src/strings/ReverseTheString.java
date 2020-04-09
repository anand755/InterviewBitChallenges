package strings;

public class ReverseTheString {
    public static void main(String[] args) {

    }

    private String solve(String string) {

        String[] words = string.split("\\s");
        int length = words.length;

        StringBuilder builder = new StringBuilder();

        for (int i = length - 1; i >= 0; i--) {
            builder.append(words[i]).append(" ");
        }

        return builder.toString().trim();

    }
}
