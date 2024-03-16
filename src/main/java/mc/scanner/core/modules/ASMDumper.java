package mc.scanner.core.modules;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceMethodVisitor;

public class ASMDumper extends MethodVisitor {
    private final TraceMethodVisitor tmv;
    private final Textifier textifier;
    public ASMDumper(String fileName, MethodVisitor mv) {
        super(Opcodes.ASM9);

        this.textifier = new Textifier();
        this.tmv = new TraceMethodVisitor(mv, textifier);
    }

    @Override
    public void visitCode() {
        tmv.visitCode();
    }

    @Override
    public void visitInsn(int opcode) {
        tmv.visitInsn(opcode);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        this.tmv.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitLdcInsn(Object cst) {
        this.tmv.visitLdcInsn(cst);
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        this.tmv.visitVarInsn(opcode, var);
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        this.tmv.visitTypeInsn(opcode, type);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        this.tmv.visitFieldInsn(opcode, owner, name, descriptor);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        this.tmv.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
    }

    @Override
    public void visitEnd() {
        this.tmv.visitEnd();

        System.out.println(this.textifier.text);
    }
}
