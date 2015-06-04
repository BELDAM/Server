package userInterface;

public class Writer {

    public static final int CENTER = 1;

    private Writer() {
    }

    public static String WriteLine(String text, int position) {
        String[] lines = Screens.emptyScreen().split("\r\n");

        switch (position) {
            case CENTER:
                String newLine;
                int begin = (int) Math.floor((lines[18].length() - text.length()) / 2.0);
                int end = lines[18].length() - (int) Math.ceil((lines[18].length() - text.length()) / 2.0);
                newLine = lines[18].substring(0, begin);
                newLine += text;
                newLine += lines[18].substring(end);
                lines[18] = newLine;
        }
        return String.join("\r\n", lines);
    }
}
