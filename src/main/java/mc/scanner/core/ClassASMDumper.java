package mc.scanner.core;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ClassASMDumper extends PrintWriter {
    private final StringWriter stringWriter;

    public ClassASMDumper() {
        super(new StringWriter());
        stringWriter = (StringWriter) out;
    }

    public String getOutput() {
        return stringWriter.toString();
    }
}
