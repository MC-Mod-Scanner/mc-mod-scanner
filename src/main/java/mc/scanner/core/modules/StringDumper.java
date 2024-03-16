package mc.scanner.core.modules;

import mc.scanner.core.strings.StringManager;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class StringDumper extends MethodVisitor {
    private final String fileName;
    public StringDumper(String fileName) {
        super(Opcodes.ASM9);

        this.fileName = fileName;
    }

    @Override
    public void visitLdcInsn(Object cst) {
        if (cst instanceof String str) {
            int nullCount = containsNullBytes(str);

            StringManager.addString(
                    fileName,
                    str,
                    nullCount
            );
        }
    }

    @Override
    public void visitEnd() {
    }

    private int containsNullBytes(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\0') {
                count++;
            }
        }

        return count;
    }
}
