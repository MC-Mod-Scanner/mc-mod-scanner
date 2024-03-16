package mc.scanner.core.modules;

import mc.scanner.core.code.Warning;
import mc.scanner.core.code.Owners;
import mc.scanner.core.code.WarningManager;
import mc.scanner.core.code.WarningType;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ByteCodeAnalyzer extends MethodVisitor {
    private final String fileName;

    public ByteCodeAnalyzer(String fileName) {
        super(Opcodes.ASM9);
        this.fileName = fileName;
    }

    @Override
    public void visitCode() {
    }

    @Override
    public void visitInsn(int opcode) {
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
    }

    @Override
    public void visitLdcInsn(Object cst) {
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        // this.tmv.visitMethodInsn(opcode, owner, name, descriptor, isInterface);

        if (Owners.Process.contains(owner)) {
            WarningManager.addWarningTop(
                    this.fileName,
                    new Warning(WarningType.PROCESS_CODE, "")
            );
        }

        if (Owners.Runtime.contains(owner)) {
            WarningManager.addWarningTop(
                    this.fileName,
                    new Warning(WarningType.RUNTIME_CODE, "")
            );
        }

        /*
        if (Owners.System.contains(owner)) {
            WarningManager.addWarning(
                    this.fileName,
                    new Warning(WarningType.SYSTEM_CODE, "")
            );
        }
        if (Owners.URI.contains(owner)) {
            WarningManager.addWarning(
                    this.fileName,
                    new Warning(WarningType.URI_CODE, "")
            );
        }
        if (Owners.URL.contains(owner)) {
            WarningManager.addWarning(
                    this.fileName,
                    new Warning(WarningType.URL_CODE, "")
            );
        }
         */

        if (Owners.Class.contains(owner) && name.equals("forName")) {
            WarningManager.addWarningTop(
                    this.fileName,
                    new Warning(WarningType.DYNAMIC_CLASS_CODE, "")
            );
        }

        if (Owners.System.contains(owner) && name.equals("load")) {
            WarningManager.addWarningTop(
                    this.fileName,
                    new Warning(WarningType.DYNAMIC_LIBRARY_CODE, "")
            );
        }


        if (Owners.HTTP.contains(owner)) {
            WarningManager.addWarningTop(
                    this.fileName,
                    new Warning(WarningType.HTTP_CODE, "")
            );
        }

        if (Owners.NetworkInterface.contains(owner)) {
            WarningManager.addWarningTop(
                    this.fileName,
                    new Warning(WarningType.NETWORK_INTERFACE_CODE, "")
            );
        }

        if (Owners.Proxy.contains(owner)) {
            WarningManager.addWarningTop(
                    this.fileName,
                    new Warning(WarningType.PROXY_CODE, "")
            );
        }

        if (Owners.TCP.contains(owner)) {
            WarningManager.addWarningTop(
                    this.fileName,
                    new Warning(WarningType.TCP_CODE, "")
            );
        }

        if (Owners.UDP.contains(owner)) {
            WarningManager.addWarningTop(
                    this.fileName,
                    new Warning(WarningType.UDP_CODE, "")
            );
        }

    }

    @Override
    public void visitEnd() {
    }

}
