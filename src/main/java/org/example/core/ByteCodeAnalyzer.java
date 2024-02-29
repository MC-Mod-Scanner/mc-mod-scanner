package org.example.core;

import org.example.core.warning.Owners;
import org.example.core.warning.Warning;
import org.example.core.warning.WarningManager;
import org.example.core.warning.WarningType;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ByteCodeAnalyzer extends MethodVisitor {
    private String previousString;
    private String fileName;
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
            if (cst instanceof String) {
                this.previousString = (String) cst;
            }
        }

        @Override
        public void visitVarInsn(int opcode, int var) {
        }

        @Override
        public void visitTypeInsn(int opcode, String type) {
        }

        @Override
        public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
            //System.out.println("    " + Printer.OPCODES[opcode] + " " + owner + "." + name + " " + descriptor);
        }

        @Override
        public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
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
