package mc.scanner.core;

import mc.scanner.MCModScanner;
import mc.scanner.core.modules.ByteCodeAnalyzer;
import mc.scanner.core.modules.StringDumper;
import org.objectweb.asm.*;
import org.objectweb.asm.util.TraceClassVisitor;

public class ClassAnalyzer extends ClassVisitor{
    private String fileName;
    private ClassWriter cw;
    private TraceClassVisitor cv;
    private ClassASMDumper asmDumper;
    public ClassAnalyzer(String fileName) {
        super(Opcodes.ASM9);

        // this.cw = new ClassWriter(0);
        // this.cv = new TraceClassVisitor(this.cw, this.asmDumper);
        // this.asmDumper = new ClassASMDumper();

        this.fileName = fileName;
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        // cv.visit(version, access, name, signature, superName, interfaces);
    }

    public void visitSource(String source, String debug) {
        // cv.visitSource(source, debug);
    }

    public void visitOuterClass(String owner, String name, String desc) {
        // cv.visitOuterClass(owner, name, desc);
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        // cv.visitAnnotation(desc, visible);
        return null;
    }

    public void visitAttribute(Attribute attr) {
        // cv.visitAttribute(attr);
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        // cv.visitInnerClass(name, outerName, innerName, access);
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        // cv.visitField(access, name, desc, signature, value);
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        // this.cv.visitMethod(access, name, desc, signature, exceptions);
        // MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);

        switch (MCModScanner.SCAN_MODE) {
            case STRING -> {
                return new StringDumper(this.fileName);
            }
            default -> {
                return new ByteCodeAnalyzer(this.fileName);
            }
        }
    }

    public void visitEnd() {
        //cv.visitEnd();
    }

}
