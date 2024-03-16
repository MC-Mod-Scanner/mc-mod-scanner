package mc.scanner.core.strings;

import java.util.ArrayList;
import java.util.List;

public class ClassStrings {
    private final String classPath;
    private final List<String> strings;
    private int nullByteCount;

    public ClassStrings(String classPath) {
        this.classPath = classPath;
        this.strings = new ArrayList<>();
    }

    public void addString(String string, int count) {
        if (count != string.length()) {
            this.strings.add(string);
        }

        this.nullByteCount += count;
    }

    public List<String> getStrings() {
        return this.strings;
    }

    public String getClassPath() {
        return this.classPath;
    }

    public int getNullByteCount() {
        return this.nullByteCount;
    }
}
